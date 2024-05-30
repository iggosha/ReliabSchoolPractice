package org.reliabschool.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person1 {

    String lastName;

    String firstName;

    String middleName;

    Integer age;

    Integer clothesSize;
}
