package org.reliabschool.service;

import org.reliabschool.entity.River;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static java.lang.System.out;

public class RiverService {

    public final River[] rivers = {
            new River("1", "1", 1),
            new River("2", "2", 2),
            new River("3", "3", 3),
            new River("4", "4", 4),
            new River("5", "5", 5),
    };

    public final Scanner scanner = new Scanner(System.in);

    private static double getAvgLength(River[] rivers) {
        return Arrays.stream(rivers)
                .mapToInt(River::getLength)
                .average()
                .orElse(0);
    }

    public void sortRiversByNameAlphabetically(River[] rivers) {
        Arrays.sort(rivers, Comparator.comparing(River::getName));
    }

    public River findByName(River[] rivers, String name) {
        return Arrays.stream(rivers)
                .filter(river -> river.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Не найден подходящий объект"));
    }

    public void findAndEdit() {
        out.println("Введите название для поиска объекта:");
        String nameToFind = scanner.nextLine();
        River river = findByName(rivers, nameToFind);
        out.println("Введите номер поля, требующего замены:");
        out.println("1 Название");
        out.println("2 Место расположения");
        out.println("3 Длина");
        int num = Integer.parseInt(scanner.nextLine());

        out.println("Введите новое значение поля:");
        String newValue = scanner.nextLine();
        switch (num) {
            case 1 -> river.setName(newValue);
            case 2 -> river.setLocation(newValue);
            case 3 -> river.setLength(Integer.parseInt(newValue));
            default -> throw new IllegalArgumentException("Неправильно введено значение номера поля");
        }
        out.println(river);
    }


    public River getShortestRiver(River[] rivers) {
        return Arrays.stream(rivers)
                .min(Comparator.comparingInt(River::getLength))
                .orElseThrow(() -> new RuntimeException("Не найден подходящий объект"));
    }

    public River[] getRiversLongerThanAverage(River[] rivers) {
        double averageLength = getAvgLength(rivers);
        River[] riversLongerThanAverage = Arrays.stream(rivers)
                .filter(river -> river.getLength() > averageLength)
                .toArray(River[]::new);
        out.println(Arrays.toString(riversLongerThanAverage));
        return riversLongerThanAverage;
    }

}
