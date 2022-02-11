package ru.gb.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
@Transactional
public class JpaProductDao implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Iterable<Product> findAll() {
        return entityManager.createQuery("select p from Product p").getResultList();
    }

    @Override
    public Product findById(Long id) {
        TypedQuery<Product> query = entityManager.createNamedQuery("Product.findById", Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public String findNameById(Long id) {
        TypedQuery<String> query = entityManager.createNamedQuery("Product.findNameById", String.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void insert(Product product) {

    }

    @Override
    public Product save(Product product) {
        if (product.getId() == null) {
            entityManager.persist(product);
        } else {
            entityManager.merge(product);
        }
        return product;
    }

    @Override
    @Deprecated
    public void update(Product product) {
        save(product);
    }

    @Override
    public void deleteById(Long id) {
        Product savedProduct = findById(id);
        entityManager.remove(savedProduct);
    }
}
