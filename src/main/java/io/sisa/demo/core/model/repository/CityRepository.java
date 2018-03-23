package io.sisa.demo.core.model.repository;

import io.sisa.demo.core.model.domain.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on Mart, 2018
 *
 * @author isao
 */
@Repository
public interface CityRepository extends CrudRepository<City, Long> {

}
