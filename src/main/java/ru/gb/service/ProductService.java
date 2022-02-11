package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.dao.JpaProductDao;
import ru.gb.entity.Product;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final JpaProductDao productRepository;

    public Product findById(long id) {
        return productRepository.findById(id);
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
