package io.sisa.demo.core.model.repository;

import io.sisa.demo.core.model.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on Mart, 2018
 *
 * @author sisa
 */
@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    City findCityByCityCode(int cityCode);

}
