package com.projeto.rosa.services;

import com.projeto.rosa.StatusEnum;
import com.projeto.rosa.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final List<Product> products = new ArrayList<>();

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(Long id) {
        return products.stream()
                .filter(product -> id.equals(product.getId()))
                .findFirst()
                .orElse(null);
    }

    public Product createProduct(Product product) {
        Long id = generatedUniqueId();
        product.setId(id);
        products.add(product);
        return product;
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Product existingProduct = getProductById(id);
        if (existingProduct != null) {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setStatus(updatedProduct.getStatus());

            return existingProduct;
        }
        return null;
    }

    public boolean deleteProduct(Long id) {
        Product productToRemove = getProductById(id);
        if (productToRemove != null) {
            products.remove(productToRemove);
            return true;
        }
        return false;
    }

    public void changeProductStatus(Long id) {
        Product product = getProductById(id);

        if (product != null) {
            if (product.getStatus() == StatusEnum.DISPONIVEL) {
                product.setStatus(StatusEnum.INDISPONIVEL);
            } else {
                product.setStatus(StatusEnum.DISPONIVEL);
            }
        }
    }

    private Long generatedUniqueId() {
        long maxId = products.stream()
                .mapToLong(Product::getId)
                .max()
                .orElse(0L);
        return maxId + 1;
    }
}
