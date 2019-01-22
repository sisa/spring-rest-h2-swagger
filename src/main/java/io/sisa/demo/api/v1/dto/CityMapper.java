package io.sisa.demo.api.v1.dto;

import io.sisa.demo.core.model.domain.City;
import org.mapstruct.Mapper;

/**
 * Created by isaozturk on 21.01.2019
 */
@Mapper
public interface CityMapper {

    CityDTO toDTO(City source);

    City toEntity(CityDTO source);
}
