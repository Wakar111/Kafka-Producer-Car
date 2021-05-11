package com.example.carmodels.car;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class MapService {

    @Autowired
    private final CarRepository carRepository;

    public List<CarDTO> getMinInfoCars() {
        return carRepository.findAll().stream()
                .map(this::convertToMinInfoCars).collect(Collectors.toList());
    }

    private CarDTO convertToMinInfoCars(Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setName(car.getName());
        carDTO.setModelNummer(car.getModelNummer());
        carDTO.setPs(car.getPs());
        carDTO.setPrice(car.getPrice());
        return carDTO;
    }

}
