package org.reliabschool.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Film {

    String name;

    Integer yearOfPublication;

    String country;

    String genre;

    Integer price;
}
