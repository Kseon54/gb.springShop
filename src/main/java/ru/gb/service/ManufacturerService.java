package ru.gb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.dao.ManufacturerDao;
import ru.gb.entity.Manufacturer;

@Service
public class ManufacturerService extends BaseService<Manufacturer>{

    private final ManufacturerDao manufacturerDao;

    @Autowired
    public ManufacturerService(ManufacturerDao manufacturerDao) {
        super(manufacturerDao);
        this.manufacturerDao = manufacturerDao;
    }
}
