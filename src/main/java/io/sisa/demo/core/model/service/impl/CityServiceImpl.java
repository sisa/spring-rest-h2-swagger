package io.sisa.demo.core.model.service.impl;


import io.sisa.demo.core.exceptions.ResourceNotFoundException;
import io.sisa.demo.core.model.domain.City;
import io.sisa.demo.core.model.repository.CityRepository;
import io.sisa.demo.core.model.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created on Mart, 2018
 *
 * @author sisa
 */

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService{

	private final CityRepository cityRepository;


	@Override
	public List<City> fetchAllCities() {
		return null;
	}

	@Override
	public City findById(Long id){

		return cityRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("general.NotFound.resource", "id", id));

	}

	@Transactional
	@Override
	public void delete(City city) {
		cityRepository.delete(city);
	}

	@Transactional
	@Override
	public void save(City city) {
		 cityRepository.save(city);
	}
}
