package org.reliabschool.service;

import org.reliabschool.entity.Person2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static java.lang.System.out;

public class Person2Service {


    public final Person2[] people = {
            new Person2("1", "1", true, 1),
            new Person2("2", "2", true, 2),
            new Person2("3", "3", false, 3),
            new Person2("4", "4", false, 4),
            new Person2("5", "5", true, 5),
    };

    public final Scanner scanner = new Scanner(System.in);

    public void calculateAverageHeightByGender(Person2[] people) {
        double averageMaleHeight = Arrays.stream(people)
                .filter(Person2::getIsMale)
                .mapToInt(Person2::getHeight)
                .average()
                .orElseThrow(() -> new RuntimeException("Не найден подходящий объект"));

        double averageFemaleHeight = Arrays.stream(people)
                .filter(person -> !person.getIsMale())
                .mapToInt(Person2::getHeight)
                .average()
                .orElseThrow(() -> new RuntimeException("Не найден подходящий объект"));

        out.println("Средний рост мужчин: " + averageMaleHeight);
        out.println("Средний рост женщин: " + averageFemaleHeight);
    }


    public Person2 findTallestMan(Person2[] people) {
        return Arrays.stream(people)
                .filter(Person2::getIsMale)
                .max(Comparator.comparingInt(Person2::getHeight))
                .orElseThrow(() -> new RuntimeException("Не найден подходящий объект"));
    }


    public void sortPeopleByHeight(Person2[] people) {
        Arrays.sort(people, Comparator.comparingInt(Person2::getHeight));
    }


    public Person2 findByLastName(Person2[] people, String lastName) {
        return Arrays.stream(people)
                .filter(person -> person.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Не найден подходящий объект"));
    }


    public void findAndEdit() {
        out.println("Введите название для поиска объекта:");
        String nameToFind = scanner.nextLine();
        Person2 person = findByLastName(people, nameToFind);
        out.println("Введите номер поля, требующего замены:");
        out.println("1 Фамилия");
        out.println("2 Имя");
        out.println("3 Пол");
        out.println("4 Рост");
        int num = Integer.parseInt(scanner.nextLine());

        out.println("Введите новое значение поля:");
        String newValue = scanner.nextLine();
        switch (num) {
            case 1 -> person.setLastName(newValue);
            case 2 -> person.setFirstName(newValue);
            case 3 -> person.setIsMale(Boolean.parseBoolean(newValue));
            case 4 -> person.setHeight(Integer.parseInt(newValue));
            default -> throw new IllegalArgumentException("Неправильно введено значение номера поля");
        }
        out.println(person);
    }
}
