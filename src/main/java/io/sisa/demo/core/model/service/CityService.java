package io.sisa.demo.core.model.service;

import io.sisa.demo.core.model.domain.City;

import java.util.List;

/**
 * Created on Mart, 2018
 *
 * @author sisa
 */
public interface CityService {

	List<City> fetchAllCities();

	City findById(Long id);

	void delete(City city);

	void save(City city);
}
