package org.reliabschool.service;

import org.reliabschool.entity.Lake;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static java.lang.System.out;

public class LakeService {

    public final Lake[] lakes = {
            new Lake("1", "1", 1),
            new Lake("2", "2", 2),
            new Lake("3", "3", 3),
            new Lake("4", "4", 4),
            new Lake("5", "5", 5),
    };

    public final Scanner scanner = new Scanner(System.in);


    public static Lake getLargestLake(Lake[] lakes) {
        return Arrays.stream(lakes)
                .max(Comparator.comparingInt(Lake::getSquare))
                .orElseThrow(() -> new RuntimeException("Не найден подходящий объект"));
    }


    public static long countLakesLessThanAverageSquare(Lake[] lakes) {
        double averageSquare = getAvgSquare(lakes);
        return Arrays.stream(lakes)
                .filter(lake -> lake.getSquare() < averageSquare)
                .count();
    }

    private static double getAvgSquare(Lake[] lakes) {
        return Arrays.stream(lakes)
                .mapToInt(Lake::getSquare)
                .average()
                .orElse(0);
    }

    public static void sortLakesByName(Lake[] lakes) {
        Arrays.sort(lakes, Comparator.comparing(Lake::getName));
    }

    // Поиск по названию озера
    public static Lake findByName(Lake[] lakes, String name) {
        return Arrays.stream(lakes)
                .filter(lake -> lake.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Не найден подходящий объект"));
    }

    public void findAndEdit() {
        out.println("Введите название для поиска объекта:");
        String nameToFind = scanner.nextLine();
        Lake lake = findByName(lakes, nameToFind);
        out.println("Введите номер поля, требующего замены:");
        out.println("1 Название");
        out.println("2 Место расположения");
        out.println("3 Площадь");
        int num = Integer.parseInt(scanner.nextLine());

        out.println("Введите новое значение поля:");
        String newValue = scanner.nextLine();
        switch (num) {
            case 1 -> lake.setName(newValue);
            case 2 -> lake.setLocation(newValue);
            case 3 -> lake.setSquare(Integer.parseInt(newValue));
            default -> throw new IllegalArgumentException("Неправильно введено значение номера поля");
        }
        out.println(lake);
    }
}
