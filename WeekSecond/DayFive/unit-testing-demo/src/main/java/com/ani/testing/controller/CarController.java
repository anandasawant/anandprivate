package com.ani.testing.controller;

import com.ani.testing.domain.Car;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDate;
//
//
//@RequestMapping("/car")
//@RestController
//public class CarController {
//
////    @GetMapping("/hi") // GET - http://localhost:8080/car/hi
////    public String sayHi() {
////        return "hi";
////    }
////
////    @PostMapping // POST - http://localhost:8080/car/
////    public Car saveCar(@RequestBody Car car) {
////        var car = new Car();
////        car.setSpeed(0);
////        car.setFwd(false);
////        car.setParts( car.getParts() );
////        return  car;
////    }
//
//    @GetMapping
//    public ResponseEntity<Car> getCar() {
//        var car = new Car();
//        car.setCost(56.23);
//        car.setId(10L);
//        car.setModel("abc");
//        car.setMfg(Date.valueOf(LocalDate.now()));
//        return ResponseEntity.ok(car);
//    }
//}

import com.ani.testing.domain.Car;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;

@RequestMapping("/car")
@RestController
public class CarController {

    @GetMapping
    public ResponseEntity<Car> getCar() {
        var car = new Car();
        car.setCost(56.23);
        car.setId(10L);
        car.setModel("abc");
        car.setMfg(Date.valueOf(LocalDate.now()));
        return ResponseEntity.ok(car);
    }
}
