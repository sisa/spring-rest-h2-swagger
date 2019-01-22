package io.sisa.demo.api.v1.controller;

import io.sisa.demo.api.v1.CityHelperService;
import io.sisa.demo.api.v1.dto.CityDTO;
import io.sisa.demo.api.v1.dto.CityMapper;
import io.sisa.demo.core.model.domain.City;
import io.sisa.demo.core.model.service.CityService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@AllArgsConstructor
@RequestMapping(value = "/v1/cities")
@Api(value="CityRestController", description="Operations pertaining to cities in Demos")
public class CityRestController {

	private  final CityService cityService;
	private final CityHelperService cityHelperService;
	private final CityMapper cityMapper;

	@NewSpan
	@RequestMapping(value = "/" , method = RequestMethod.POST)
	public ResponseEntity<Long> addCity(@RequestBody CityDTO cityDTO){

		log.info("addCity");

		/*City cityEntity = new City();
		cityEntity.setCityName(city.getCityName());
		cityEntity.setCityCode(city.getCityCode());
		cityEntity.setCountry(city.getCountry());
		cityEntity.setValidityDateTime(city.getValidityEndDate());*/

		final City city = cityMapper.toEntity(cityDTO);

		cityService.save(city);

		return new ResponseEntity<>(city.getId(),HttpStatus.CREATED);

	}

	@NewSpan
	@RequestMapping(value = "{id}" , method = RequestMethod.GET)
	public ResponseEntity<CityDTO> getCityById(@PathVariable("id") Long id){

		log.info("getCityById-id:"+id);

		City city=cityService.findById(id);

		CityDTO cityDTO =  cityHelperService.mapping(city);

		return new ResponseEntity<>(cityDTO,HttpStatus.OK);

	}

	@NewSpan
	@RequestMapping(value = "{id}" , method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteCityById(@PathVariable("id") Long id){

		City city = cityService.findById(id);

		cityService.delete(city);

		return new ResponseEntity<>("Deleted",HttpStatus.OK);


	}


}
