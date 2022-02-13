package ru.gb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.dao.ProductDao;
import ru.gb.entity.Product;

@Service
public class ProductService extends BaseService<Product> {

    private final ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao) {
        super(productDao);
        this.productDao = productDao;
    }

}
