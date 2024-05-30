package org.reliabschool.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Theatre {

    String name;

    String artisticDirector;

    String address;

    Integer rating;
}
