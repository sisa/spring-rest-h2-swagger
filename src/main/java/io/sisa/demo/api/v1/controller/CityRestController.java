package io.sisa.demo.api.v1.controller;

import io.sisa.demo.api.v1.CityHelperService;
import io.sisa.demo.api.v1.dto.CityDTO;
import io.sisa.demo.core.model.domain.City;
import io.sisa.demo.core.model.service.CityService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created on Mart, 2018
 *
 * @author sisa
 */
@Slf4j
@RestController
@RequestMapping(value = "/v1/city")
@Api(value="CityRestController", description="Operations pertaining to cities in Demos")
public class CityRestController {

	private  final CityService cityService;
	private final CityHelperService cityHelperService;

	@Autowired
	public CityRestController(CityService cityService, CityHelperService cityHelperService) {
		this.cityService = cityService;
		this.cityHelperService = cityHelperService;
	}

	@NewSpan
	@RequestMapping(value = "/" , method = RequestMethod.POST)
	public ResponseEntity<CityDTO> addCity(@RequestBody CityDTO city){

		log.info("addCity");

		City cityEntity = new City();
		cityEntity.setCityName(city.getCityName());
		cityEntity.setCityCode(city.getCityCode());
		cityEntity.setCountry(city.getCountry());

		cityService.save(cityEntity);
		city.setCityId(cityEntity.getId());

		return new ResponseEntity<>(city,HttpStatus.CREATED);

	}

	@NewSpan
	@RequestMapping(value = "{id}" , method = RequestMethod.GET)
	public ResponseEntity<CityDTO> getCityById(@PathVariable("id") Long id){

		log.info("getCityById-id:"+id);

		City cityEntity=cityService.findById(id).orElse(null);
		if (cityEntity == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		CityDTO cityDTO =  cityHelperService.mapping(cityEntity);

		return new ResponseEntity<>(cityDTO,HttpStatus.OK);

	}

	@NewSpan
	@RequestMapping(value = "{id}" , method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteCityById(@PathVariable("id") Long id){

		City cityEntity=cityService.findById(id).orElse(null);
		if (cityEntity == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		cityService.delete(cityEntity);

		return new ResponseEntity<>("Deleted",HttpStatus.OK);


	}


}
