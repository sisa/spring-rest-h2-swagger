package io.sisa.demo.core.model.service.impl;

import io.sisa.demo.core.model.domain.City;
import io.sisa.demo.core.model.repository.CityRepository;
import io.sisa.demo.core.model.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Created on Mart, 2018
 *
 * @author sisa
 */
@Service
public class CityServiceImpl implements CityService{

	private final CityRepository cityRepository;

	@Autowired
	public CityServiceImpl(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@Override
	public List<City> fetchAllCities() {
		return null;
	}

	@Override
	public Optional<City> findById(Long id) {
		return cityRepository.findById(id);
	}

	@Transactional
	@Override
	public void delete(City city) {
		cityRepository.delete(city);
	}

	@Transactional
	@Override
	public City save(City city) {
		return cityRepository.save(city);
	}
}
