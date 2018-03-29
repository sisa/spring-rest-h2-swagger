package io.sisa.demo.api.v1;

import io.sisa.demo.api.v1.dto.CityDTO;
import io.sisa.demo.core.model.domain.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CityHelperService {

    @NewSpan
    public CityDTO mapping(City cityEntity){

        log.info("mapping");

        CityDTO cityDTO =  new CityDTO();

        cityDTO.setCityId(cityEntity.getId());
        cityDTO.setCityName(cityEntity.getCityName());
        cityDTO.setCityCode(cityEntity.getCityCode());
        cityDTO.setCountry(cityEntity.getCountry());

        return cityDTO;
    }
}
