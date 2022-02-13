package ru.gb.dao;

import org.springframework.stereotype.Repository;
import ru.gb.entity.Manufacturer;

@Repository
public interface ManufacturerDao extends BaseDao<Manufacturer, Long> {

}
