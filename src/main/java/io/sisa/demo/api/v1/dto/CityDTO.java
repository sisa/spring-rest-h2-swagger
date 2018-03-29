package io.sisa.demo.api.v1.dto;

import lombok.Data;

/**
 * Created on Mart, 2018
 *
 * @author sisa
 */
@Data
public class CityDTO {

	private Long cityId;
	private int cityCode;
	private String cityName;
	private String country;
}
