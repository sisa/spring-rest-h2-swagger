package io.sisa.demo.api.v1.mapper;

import io.sisa.demo.api.v1.dto.CityDTO;
import io.sisa.demo.core.model.domain.City;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Created by isaozturk on 21.01.2019
 */
@Mapper
public interface CityMapper {

    CityDTO toDTO(City source);

    City toEntity(CityDTO source);

    List<CityDTO> toDTO(List<City> source);
}
