package com.projeto.rosa.controller;

import com.projeto.rosa.model.Product;
import com.projeto.rosa.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String listProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "product-list"; // Retorna o nome da página HTML a ser renderizada
    }

    @GetMapping("/products/{id}")
    public String viewProduct(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        if (product != null) {
            model.addAttribute("product", product);
            return "product-details";
        } else {
            return "not-found"; // Página de erro para produto não encontrado
        }
    }

    @GetMapping("/products/create")
    public String createProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "create-product"; // Retorna o nome da página HTML do formulário de criação
    }

    @PostMapping("/products/create")
    public String createProduct(@ModelAttribute Product product) {
        productService.createProduct(product);
        return "redirect:/products"; // Redireciona de volta para a lista de produtos após a criação
    }

    @GetMapping("/products/edit/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        if (product != null) {
            model.addAttribute("product", product);
            return "edit-product"; // Retorna o nome da página HTML do formulário de edição
        } else {
            return "not-found"; // Página de erro para produto não encontrado
        }
    }

    @PostMapping("/products/edit/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product updatedProduct) {
        productService.updateProduct(id, updatedProduct);
        return "redirect:/products"; // Redireciona de volta para a lista de produtos após a atualização
    }

    @PostMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products"; // Redireciona de volta para a lista de produtos após a exclusão
    }

    @PostMapping("/products/changeStatus/{id}")
    public String changeProductStatus(@PathVariable Long id) {
        productService.changeProductStatus(id);
        return "redirect:/products"; // Redireciona de volta para a lista de produtos após a mudança de status
    }
}
