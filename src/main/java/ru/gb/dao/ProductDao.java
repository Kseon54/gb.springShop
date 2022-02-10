package ru.gb.dao;

import ru.gb.entity.Product;

public interface ProductDao {
    Iterable<Product> findAll();
    Product findById(Long id);
    String findNameById(Long id);
    void insert(Product manufacturer);
    Product save(Product manufacturer);
    void update(Product manufacturer);
    void deleteById(Long id);
}
