package com.example.carmodels.controller;

import com.example.carmodels.car.Car;
import com.example.carmodels.car.CarDTO;
import com.example.carmodels.car.CarService;
import com.example.carmodels.car.MapService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class CarController {

    @Autowired
    private final CarService carService;
    @Autowired
    private final MapService mapService;
    @Autowired
    private final KafkaTemplate<String, Car> kafkaTemplate;

    private final static String topic = "java-example-json";

    @GetMapping(value = "/cars")
    public List<CarDTO> getAllCars(){
        return mapService.getMinInfoCars();
    }

    @PostMapping(value = "/addcar")
    public void addNewCar(@RequestBody Car car) {
        kafkaTemplate.send(topic, car);
        carService.addCar(car);
    }

    @DeleteMapping(value = "/car/{id}")
    public void deleteCar(@PathVariable("id") Long id) {
        carService.deleteCar(id);
    }

}
