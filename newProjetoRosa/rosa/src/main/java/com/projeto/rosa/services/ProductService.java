package com.projeto.rosa.services;

import com.projeto.rosa.StatusEnum;
import com.projeto.rosa.dto.ProductDto;
import com.projeto.rosa.model.Product;
import com.projeto.rosa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(@ModelAttribute ProductDto productDto) {
        final var product = new Product();
        product.setId(UUID.randomUUID());
        product.setName(productDto.getName());
        product.setStatus(StatusEnum.DISPONIVEL);
        product.setDestination(productDto.getDestination());
        product.setProfitRate(productDto.getProfitRate());
        product.setTerm(productDto.getTerm());
        product.setAdministrationRate(productDto.getAdministrationRate());

        productRepository.save(product);
    }

    public Product changeProductStatus(Long id) {
        Product product = getProductById(id);

        if (product != null) {
            if (product.getStatus() == StatusEnum.DISPONIVEL) {
                product.setStatus(StatusEnum.INDISPONIVEL);
            } else {
                product.setStatus(StatusEnum.DISPONIVEL);
            }

            return productRepository.save(product);
        }

        return null;
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
