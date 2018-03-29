package io.sisa.demo.core.model.service;

import io.sisa.demo.core.model.domain.City;

import java.util.List;
import java.util.Optional;

/**
 * Created on Mart, 2018
 *
 * @author sisa
 */
public interface CityService {

	List<City> fetchAllCities();
	Optional<City> findById(Long id);
	void delete(City city);
	City save(City city);
}
