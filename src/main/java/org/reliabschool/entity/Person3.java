package org.reliabschool.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person3 {

    String lastName;

    String firstName;

    Integer yearOfBirth;

    Integer monthOfBirth;
}
