package com.example.carmodels.car;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String dealer;
    private String modelNummer;
    private Integer year;
    private Integer ps;
    private Long price;

    public Car(String name, String dealer, String modelNummer, Integer year, Integer ps, Long price) {
        this.name = name;
        this.dealer = dealer;
        this.modelNummer = modelNummer;
        this.year = year;
        this.ps = ps;
        this.price = price;
    }

}
