package hw30.service;

import hw30.model.City;

import java.util.Optional;

public interface CityService {

    Optional<City> findByCode(Integer code);
    City save(City city);
    void deleteByCode(Integer code);
}
