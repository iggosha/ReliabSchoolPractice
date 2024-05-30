package org.reliabschool.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    String name;

    String manufacturer;

    Integer quantity;

    Integer price;
}
