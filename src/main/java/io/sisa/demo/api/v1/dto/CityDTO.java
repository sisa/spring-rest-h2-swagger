package io.sisa.demo.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created on Mart, 2018
 *
 * @author sisa
 */
@Data
public class CityDTO {

	private Long id;

	private int cityCode;

	private String cityName;

	private String country;

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime validityEndDate;
}
