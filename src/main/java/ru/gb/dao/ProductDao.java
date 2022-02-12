package ru.gb.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.entity.Product;

@Repository
public interface ProductDao extends CrudRepository<Product, Long> {

}
