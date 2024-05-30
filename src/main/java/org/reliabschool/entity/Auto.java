package org.reliabschool.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Auto {

    String model;

    Integer regNumber;

    Integer yearOfManufacture;

    Integer mileage;

    Integer cost;
}
