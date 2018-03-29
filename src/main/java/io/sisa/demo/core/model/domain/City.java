package io.sisa.demo.core.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created on Mart, 2018
 *
 * @author sisa
 */
@Data
@Entity
@Table(name = "city")
public class City implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "city_code")
	private int cityCode;

	@Column(name = "city_name")
	private String cityName;

	@Column(name = "country")
	private String country;

}
