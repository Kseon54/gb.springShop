package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.dao.ProductDao;
import ru.gb.entity.Product;
import ru.gb.exception.NotFoundException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDao productDao;

    public Product findById(long id) {
        Optional<Product> manufacturer = productDao.findById(id);
        return manufacturer.orElseThrow(NotFoundException::new);
    }

    public Iterable<Product> findAll() {
        return productDao.findAll();
    }

    public Product save(Product product) {
        return productDao.save(product);
    }

    public void delete(Long id) {
        productDao.deleteById(id);
    }
}
