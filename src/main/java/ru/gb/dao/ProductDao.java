package ru.gb.dao;

import org.springframework.stereotype.Repository;
import ru.gb.entity.Product;

@Repository
public interface ProductDao extends BaseDao<Product, Long> {

}
