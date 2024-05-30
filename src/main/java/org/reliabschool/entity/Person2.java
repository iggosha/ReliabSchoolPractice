package org.reliabschool.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person2 {

    String lastName;

    String firstName;

    Boolean isMale;

    Integer height;
}
