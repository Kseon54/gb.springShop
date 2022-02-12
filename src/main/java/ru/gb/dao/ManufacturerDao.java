package ru.gb.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.entity.Manufacturer;

@Repository
public interface ManufacturerDao extends CrudRepository<Manufacturer, Long> {

}
