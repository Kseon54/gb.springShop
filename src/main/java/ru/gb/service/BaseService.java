package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.dao.BaseDao;
import ru.gb.entity.BaseEntity;
import ru.gb.entity.enums.Status;
import ru.gb.exception.NotFoundException;

@RequiredArgsConstructor
public abstract class BaseService<T extends BaseEntity<T>> {
    private final BaseDao<T, Long> repository;

    public Iterable<T> findAllActive(int page, int size) {
        return repository.findByStatus(Status.ACTIVE, PageRequest.of(page, size));
    }

    public Iterable<T> findAllActive() {
        return repository.findByStatus(Status.ACTIVE);
    }

    public Iterable<T> findAllActiveSortedBy(Sort.Direction direction, String column) {
        return repository.findByStatus(Status.ACTIVE, Sort.by(direction, column));
    }

    public Iterable<T> findAllActiveSortedBy(Sort.Direction direction, String column, int page, int size) {
        return repository.findByStatus(Status.ACTIVE, PageRequest.of(page, size, Sort.by(direction, column)));
    }


    public void disableById(Long id) {
        T entity = findById(id);
        entity.setStatus(Status.DISABLE);
        save(entity);
    }

    public void activeById(Long id) {
        T entity = findById(id);
        entity.setStatus(Status.ACTIVE);
        save(entity);
    }

    public T save(T entity) {
        return repository.save(entity);
    }

    public Iterable<T> saveAll(Iterable<T> entities) {
        return repository.saveAll(entities);
    }

    @Transactional(readOnly = true)
    public T findById(long id) {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional(readOnly = true)
    public Iterable<T> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Iterable<T> findAllById(Iterable<Long> ids) {
        return repository.findAllById(ids);
    }

    public long count() {
        return repository.count();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void delete(T entity) {
        repository.delete(entity);
    }

    public void deleteAllById(Iterable<Long> ids) {
        repository.findAllById(ids);
    }

    public void deleteAll(Iterable<T> entities) {
        repository.deleteAll(entities);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
