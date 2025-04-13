package org.example.db_lb_3.service;

import org.example.db_lb_3.models.Product;
import org.example.db_lb_3.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getAll() {
        return repo.findAll();
    }

    public Product getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product create(Product product) {
        return repo.save(product);
    }

    public Product update(Long id, Product updatedData) {
        return repo.findById(id).map(prod -> {
            prod.setName(updatedData.getName());
            prod.setPrice(updatedData.getPrice());
            return repo.save(prod);
        }).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Product> findExpensiveProducts(double price) {
        return repo.findByPriceGreaterThan(price);
    }
}
