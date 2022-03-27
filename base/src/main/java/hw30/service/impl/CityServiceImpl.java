package hw30.service.impl;

import hw30.model.City;
import hw30.repository.CityRepository;
import hw30.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public Optional<City> findByCode(Integer code) {
        return cityRepository.findById(code);
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public void deleteByCode(Integer code) {
        cityRepository.deleteById(code);
    }
}
