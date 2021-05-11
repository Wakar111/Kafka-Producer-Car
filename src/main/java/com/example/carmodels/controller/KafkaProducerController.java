package com.example.carmodels.controller;

import com.example.carmodels.car.Car;
import com.example.carmodels.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("kafka")
public class KafkaProducerController {

    @Autowired
    private CarService carService;

    @Autowired
    private KafkaTemplate<String, Car> kafkaTemplate;

    private final static String topic = "java-example-json";

    @GetMapping("/cars")
    public String sendAllCarsToTopic() {
        List<Car> carList = carService.getAllCars();
        for (Car car : carList) {

            kafkaTemplate.send(topic, car);
        }
        return "Published successfully";
    }

//    @GetMapping("/test/{msg}")
//    public String sendAllCarsToTopic(@PathVariable("msg") String msg) {
//            msgKafkaTemplate.send(topic, msg);
//        return "Published successfully";
//    }
}
