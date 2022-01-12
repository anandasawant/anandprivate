package com.ani.orm.demo.repository;

import com.ani.orm.demo.domain.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarCrudRepo extends CrudRepository<Car, Long> {
}
