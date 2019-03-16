package io.sisa.demo.api.v1.controller;

import io.sisa.demo.api.v1.dto.CityDTO;
import io.sisa.demo.api.v1.mapper.CityMapper;
import io.sisa.demo.api.v1.response.RestResponse;
import io.sisa.demo.core.model.domain.City;
import io.sisa.demo.core.model.service.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created on Mart, 2018
 *
 * @author sisa
 */
@Slf4j
@Validated
@RestController
@AllArgsConstructor
@RequestMapping(value = "/v1/cities")
@Api(value = "City Rest Controller", description = "Operations pertaining to cities in Demos")
public class CityRestController {

	private  final CityService cityService;

	private final CityMapper cityMapper;

	@NewSpan
    @PostMapping(value = "/")
    @ApiOperation(value = "add city", notes = "add city", response = Long.class)
    public ResponseEntity<Long> addCity(@ApiParam @Validated @RequestBody CityDTO cityDTO) {

		log.info("addCity");

		final City city = cityMapper.toEntity(cityDTO);

		cityService.save(city);

		return new ResponseEntity<>(city.getId(),HttpStatus.CREATED);

	}

	@NewSpan
    @GetMapping(value = "{id}")
    @ApiOperation(value = "find city by id", notes = "get find by id", response = RestResponse.class)
    public ResponseEntity<RestResponse<CityDTO>> findById(@PathVariable("id") Long id) {

        final City city = cityService.findById(id);

        final CityDTO cityDTO = cityMapper.toDTO(city);

        return new ResponseEntity<>(RestResponse.of(cityDTO), HttpStatus.OK);

	}

	@NewSpan
    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {

        final City city = cityService.findById(id);

		cityService.delete(city);

		return new ResponseEntity<>("Deleted",HttpStatus.OK);


	}


}
