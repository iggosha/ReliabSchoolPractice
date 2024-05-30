package org.reliabschool.service;

import org.reliabschool.entity.Mountain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static java.lang.System.out;

public class MountainService {

    public final Mountain[] mountains = {
            new Mountain("1", "1", 1),
            new Mountain("2", "1", 2),
            new Mountain("3", "1", 3),
            new Mountain("4", "1", 4),
            new Mountain("5", "1", 5),
    };

    public final Scanner scanner = new Scanner(System.in);

    public Mountain getHighestPeak(Mountain[] mountains) {
        return Arrays.stream(mountains)
                .max(Comparator.comparingInt(Mountain::getHeight))
                .orElseThrow(() -> new RuntimeException("Не найден подходящий объект"));
    }

    public Mountain[] getPeaksAbove1000(Mountain[] mountains) {
        return Arrays.stream(mountains)
                .filter(mountain -> mountain.getHeight() > 1000)
                .toArray(Mountain[]::new);
    }

    public void sortMountainsByHeight(Mountain[] mountains) {
        Arrays.sort(mountains, Comparator.comparingInt(Mountain::getHeight));
    }

    public Mountain findByName(Mountain[] mountains, String name) {
        return Arrays.stream(mountains)
                .filter(mountain -> mountain.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Не найден подходящий объект"));
    }

    public void findAndEdit() {
        out.println("Введите название для поиска объекта:");
        String nameToFind = scanner.nextLine();
        Mountain mountain = findByName(mountains, nameToFind);

        out.println("Введите номер поля, требующего замены:");
        out.println("1 Название");
        out.println("2 Место расположения");
        out.println("3 Высота");
        int num = Integer.parseInt(scanner.nextLine());

        out.println("Введите новое значение поля:");
        String newValue = scanner.nextLine();
        switch (num) {
            case 1 -> mountain.setName(newValue);
            case 2 -> mountain.setLocation(newValue);
            case 3 -> mountain.setHeight(Integer.parseInt(newValue));
            default -> throw new IllegalArgumentException("Неправильно введено значение номера поля");
        }
        out.println(mountain);
    }
}
