package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.dao.ManufacturerDao;
import ru.gb.entity.Manufacturer;
import ru.gb.exception.NotFoundException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManufacturerService {

    private final ManufacturerDao manufacturerDao;

    public Manufacturer findById(long id) {
        Optional<Manufacturer> manufacturer = manufacturerDao.findById(id);
        return manufacturer.orElseThrow(NotFoundException::new);
    }

    public Iterable<Manufacturer> findAll() {
        return manufacturerDao.findAll();
    }

    public Manufacturer save(Manufacturer manufacturer) {
        return manufacturerDao.save(manufacturer);
    }

    public void update(Manufacturer manufacturer) {
        manufacturerDao.save(manufacturer);
    }

    public void delete(Long id) {
        manufacturerDao.deleteById(id);
    }
}
