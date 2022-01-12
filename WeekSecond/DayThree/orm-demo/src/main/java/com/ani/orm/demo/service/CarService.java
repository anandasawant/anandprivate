package com.ani.orm.demo.service;

import com.ani.orm.demo.domain.Car;
import com.ani.orm.demo.repository.CarCrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private CarCrudRepo repository;

    public Car saveCar(Car car) {
        return repository.save(car);
    }
}
