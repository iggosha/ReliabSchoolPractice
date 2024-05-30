package org.reliabschool.service;

import org.reliabschool.entity.Person1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static java.lang.System.out;

public class Person1Service {

    public final Person1[] people = {
            new Person1("1", "1", "1", 1, 1),
            new Person1("2", "2", "2", 2, 2),
            new Person1("3", "3", "3", 3, 3),
            new Person1("4", "4", "4", 4, 4),
            new Person1("5", "5", "5", 5, 5)
    };

    public final Scanner scanner = new Scanner(System.in);

    public static Person1 getPersonWithLargestClothesSize(Person1[] people) {
        return Arrays.stream(people)
                .max(Comparator.comparingInt(Person1::getClothesSize))
                .orElseThrow(() -> new RuntimeException("Не найден подходящий объект"));
    }

    public static double getAverageClothesSizeForOver40Years(Person1[] people) {
        return Arrays.stream(people)
                .filter(person -> person.getAge() > 40)
                .mapToInt(Person1::getClothesSize)
                .average()
                .orElse(0);
    }

    public void sortPeopleByClothesSizeAscending(Person1[] people) {
        Arrays.sort(people, Comparator.comparingInt(Person1::getClothesSize));
    }

    public Person1 findByLastName(Person1[] people, String lastName) {
        return Arrays.stream(people)
                .filter(person -> person.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Не найден подходящий объект"));
    }


    public void findAndEdit() {
        out.println("Введите название для поиска объекта:");
        String lastNameToFind = scanner.nextLine();
        Person1 person1 = findByLastName(people, lastNameToFind);

        out.println("Введите номер поля, требующего замены:");
        out.println("1 Фамилия");
        out.println("2 Имя");
        out.println("3 Отчество");
        out.println("4 Возраст");
        out.println("5 Размер одежды");
        int num = Integer.parseInt(scanner.nextLine());

        out.println("Введите новое значение поля:");
        String newValue = scanner.nextLine();
        switch (num) {
            case 1 -> person1.setLastName(newValue);
            case 2 -> person1.setFirstName(newValue);
            case 3 -> person1.setMiddleName(newValue);
            case 4 -> person1.setAge(Integer.parseInt(newValue));
            case 5 -> person1.setClothesSize(Integer.parseInt(newValue));
            default -> throw new IllegalArgumentException("Неправильно введено значение номера поля");
        }
        out.println(person1);
    }
}
