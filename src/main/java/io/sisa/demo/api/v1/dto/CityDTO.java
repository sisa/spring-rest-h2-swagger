package io.sisa.demo.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * Created on Mart, 2018
 *
 * @author sisa
 */

@Data
@NoArgsConstructor
public class CityDTO extends BaseDTO {

	private int cityCode;

    @NotBlank(message = "demo.validation.NotNull.city.name")
    private String cityName;

	private String country;

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime validityEndDate;

    public CityDTO(Long id, int cityCode, String cityName, String country, LocalDateTime validityEndDate) {
        super(id);
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.country = country;
        this.validityEndDate = validityEndDate;
    }
}
