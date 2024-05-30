package org.reliabschool.service;

import org.reliabschool.entity.Auto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static java.lang.System.out;

public class AutoService {

    public final Auto[] autos = {
            new Auto("1", 1, 1, 1, 1),
            new Auto("2", 2, 2, 2, 2),
            new Auto("3", 3, 3, 3, 3),
            new Auto("4", 4, 4, 4, 4),
            new Auto("5", 5, 5, 5, 5),
    };

    public final Scanner scanner = new Scanner(System.in);

    public Auto getCheapestAuto(Auto[] autos) {
        return Arrays.stream(autos)
                .min(Comparator.comparing(Auto::getCost))
                .orElseThrow(() -> new RuntimeException("Не найден подходящий объект"));
    }

    public void sortByYearDescending(Auto[] autos) {
        Arrays.sort(autos, Comparator.comparing(Auto::getYearOfManufacture).reversed());
    }

    public Auto findByRegNumber(Auto[] autos, Integer regNumber) {
        return Arrays.stream(autos)
                .filter(auto -> auto.getRegNumber().equals(regNumber))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Не найден подходящий объект"));
    }

    public void findAndEdit() {
        out.println("Введите регистрационный номер для поиска объекта:");
        Integer regNumber = Integer.parseInt(scanner.nextLine());
        Auto auto = findByRegNumber(autos, regNumber);

        out.println("Введите номер поля, требующего замены:");
        out.println("1 Модель");
        out.println("2 Регистрационный номер");
        out.println("3 Год выпуска");
        out.println("4 Пробег");
        out.println("5 Стоимость");
        int num = Integer.parseInt(scanner.nextLine());

        out.println("Введите новое значение поля:");
        String newValue = scanner.nextLine();
        switch (num) {
            case 1 -> auto.setModel(newValue);
            case 2 -> auto.setRegNumber(Integer.parseInt(newValue));
            case 3 -> auto.setYearOfManufacture(Integer.parseInt(newValue));
            case 4 -> auto.setMileage(Integer.parseInt(newValue));
            case 5 -> auto.setCost(Integer.parseInt(newValue));
            default -> throw new IllegalArgumentException("Неправильно введено значение номера поля");
        }
        out.println(auto);
    }
}
