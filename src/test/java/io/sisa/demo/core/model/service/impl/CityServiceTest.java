package io.sisa.demo.core.model.service.impl;

import io.sisa.demo.core.model.domain.City;
import io.sisa.demo.core.model.repository.CityRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

/**
 * Created by isaozturk on 21.01.2019
 */
@RunWith(MockitoJUnitRunner.class)
public class CityServiceTest {

    @Mock
    private CityRepository cityRepository;

    private CityServiceImpl cityService;

    @Before
    public void setUp() {

        this.cityService = new CityServiceImpl(cityRepository);
    }

    @Test
    public void findByIdTest(){

        City city = new City();
        city.setCityCode(53);

        Optional<City> optionalCity = Optional.of(city);

        given(cityRepository.findById(anyLong())).willReturn(optionalCity);

       assertThat(cityService.findById(1L).getCityCode()).isEqualTo(53);
    }
}
