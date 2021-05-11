package com.example.carmodels.car;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CarService {

    @Autowired
    private final CarRepository carRepository;

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public void addCar(Car car) {
        Optional<Car> carOptional = carRepository.findById(car.getId());
        if (carOptional.isPresent()) {
            Car carInDB = carOptional.get();
            carInDB.setName(car.getName());
            carInDB.setDealer(car.getDealer());
            carInDB.setYear(car.getYear());
            carInDB.setPs(car.getPs());
            carInDB.setPrice(car.getPrice());
            carRepository.save(carInDB);
        }

        carRepository.save(car);
    }

    public void deleteCar(Long id) {
        boolean exists = carRepository.existsById(id);
        if (exists) {
            carRepository.deleteById(id);
        } else {
            throw new IllegalStateException("Student with id " + id + " was not found");
        }
    }
}
