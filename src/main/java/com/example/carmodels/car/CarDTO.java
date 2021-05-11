package com.example.carmodels.car;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@ToString
public class CarDTO {
    @Id
    @GeneratedValue
    private String name;
    private String modelNummer;
    private Integer ps;
    private Long price;

}
