package ru.gb.service;

import ru.gb.entity.Product;
import ru.gb.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product findById(long id) {
        return productRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public ArrayList<Product> findAll() {
        return productRepository.findAll();
    }

    public Product save(Product product) {
        return productRepository.save(product).orElseThrow(IllegalArgumentException::new);
    }

    public Product update(long id, Product product) {
        return productRepository.update(id, product).orElseThrow(NoSuchElementException::new);
    }

    public Product delete(Product product) {
        return productRepository.delete(product).orElseThrow(NoSuchElementException::new);
    }
}
