package com.ani.orm.demo.contoller;

import com.ani.orm.demo.domain.Car;
import com.ani.orm.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/car")
@RestController
public class CarController {

    @Autowired
    private CarService service;

    @PostMapping
    private String saveCar(@RequestBody Car car) {
        service.saveCar(car);
        return "car saved successfully";
    }
}
