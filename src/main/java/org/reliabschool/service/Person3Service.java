package org.reliabschool.service;

import org.reliabschool.entity.Person3;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static java.lang.System.out;

public class Person3Service {

    public final Person3[] people = {
            new Person3("1", "1", 1, 1),
            new Person3("2", "2", 2, 2),
            new Person3("3", "3", 3, 3),
            new Person3("4", "4", 4, 4),
            new Person3("5", "5", 5, 5),
    };

    public final Scanner scanner = new Scanner(System.in);

    public static void sortPeopleByLastNameDesc(Person3[] people) {
        Arrays.sort(people, Comparator.comparing(Person3::getLastName).reversed());
    }

    public Person3 findOldestPerson(Person3[] people) {
        return Arrays.stream(people)
                .min(Comparator.comparingInt(Person3::getYearOfBirth))
                .orElseThrow(() -> new RuntimeException("Не найден подходящий объект"));
    }

    public void printPeopleAboveAverageAge(Person3[] people) {
        int currentYear = LocalDate.now().getYear();
        double averageAge = getAverageAge(people, currentYear);

        out.println("Средний возраст: " + averageAge);
        Arrays.stream(people)
                .filter(person -> (currentYear - person.getYearOfBirth()) > averageAge)
                .forEach(out::println);
    }

    private double getAverageAge(Person3[] people, int currentYear) {
        return Arrays.stream(people)
                .mapToInt(person -> currentYear - person.getYearOfBirth())
                .average()
                .orElse(0);
    }


    public Person3 findByLastName(Person3[] people, String lastName) {
        return Arrays.stream(people)
                .filter(person -> person.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Не найден подходящий объект"));
    }

    // Исправление одного из полей и вывод полной информации о человеке после редактирования
    public void editPersonInfoAndPrint() {
        out.println("Введите название для поиска объекта:");
        String nameToFind = scanner.nextLine();
        Person3 person = findByLastName(people, nameToFind);
        out.println("Введите номер поля, требующего замены:");
        out.println("1 Фамилия");
        out.println("2 Имя");
        out.println("3 Год рождения");
        out.println("4 Месяц рождения");
        int num = Integer.parseInt(scanner.nextLine());

        out.println("Введите новое значение поля:");
        String newValue = scanner.nextLine();
        switch (num) {
            case 1 -> person.setLastName(newValue);
            case 2 -> person.setFirstName(newValue);
            case 3 -> person.setYearOfBirth(Integer.parseInt(newValue));
            case 4 -> person.setMonthOfBirth(Integer.parseInt(newValue));
            default -> throw new IllegalArgumentException("Неправильно введено значение номера поля");
        }
        out.println(person);
    }
}
