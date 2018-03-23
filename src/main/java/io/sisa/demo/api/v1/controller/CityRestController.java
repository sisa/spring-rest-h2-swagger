package io.sisa.demo.api.v1.controller;

import io.sisa.demo.api.v1.dto.CityDTO;
import io.sisa.demo.core.model.domain.City;
import io.sisa.demo.core.model.service.CityService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created on Mart, 2018
 *
 * @author isao
 */
@RestController
@RequestMapping(value = "/v1/city")
@Api(value="City", description="Operations pertaining to cities in Demos")
public class CityRestController {

	private  final CityService cityService;

	@Autowired
	public CityRestController(CityService cityService) {
		this.cityService = cityService;
	}

	@RequestMapping(value = "/" , method = RequestMethod.POST)
	public ResponseEntity<CityDTO> addCity(@RequestBody CityDTO city){

		City cityEntity = new City();
		cityEntity.setCityName(city.getCityName());
		cityEntity.setCityCode(city.getCityCode());
		cityEntity.setCountry(city.getCountry());

		cityService.save(cityEntity);
		city.setCityId(cityEntity.getId());

		return new ResponseEntity<>(city,HttpStatus.CREATED);

	}

	@RequestMapping(value = "{id}" , method = RequestMethod.GET)
	public ResponseEntity<CityDTO> getCityById(@PathVariable("id") Long id){
		City cityEntity=cityService.findById(id).orElse(null);
		if (cityEntity == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		CityDTO cityDTO =  new CityDTO();

		cityDTO.setCityId(cityEntity.getId());
		cityDTO.setCityName(cityEntity.getCityName());
		cityDTO.setCityCode(cityEntity.getCityCode());
		cityDTO.setCountry(cityEntity.getCountry());

		return new ResponseEntity<>(cityDTO,HttpStatus.OK);

	}

	@RequestMapping(value = "{id}" , method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteCityById(@PathVariable("id") Long id){

		City cityEntity=cityService.findById(id).orElse(null);
		if (cityEntity == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		cityService.delete(cityEntity);

		return new ResponseEntity<>("Deleted",HttpStatus.OK);


	}


}
