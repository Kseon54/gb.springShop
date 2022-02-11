package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.dao.JpaManufacturerDao;
import ru.gb.entity.Manufacturer;

@Service
@RequiredArgsConstructor
public class ManufacturerService {

    private final JpaManufacturerDao jpaManufacturerDao;

    public Manufacturer findById(long id) {
        return jpaManufacturerDao.findById(id);
    }

    public Iterable<Manufacturer> findAll() {
        return jpaManufacturerDao.findAll();
    }

    public Manufacturer save(Manufacturer manufacturer) {
        return jpaManufacturerDao.save(manufacturer);
    }

    public void update(Manufacturer manufacturer) {
        jpaManufacturerDao.update(manufacturer);
    }

    public void delete(Long id) {
        jpaManufacturerDao.deleteById(id);
    }
}
