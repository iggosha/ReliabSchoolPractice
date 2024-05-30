package org.reliabschool.service;

import org.reliabschool.entity.Singer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static java.lang.System.out;

public class SingerService {

    public final Singer[] singers = {
            new Singer("1", 1, 1),
            new Singer("2", 2, 2),
            new Singer("3", 3, 3),
            new Singer("4", 4, 4),
            new Singer("5", 5, 5),
    };

    public final Scanner scanner = new Scanner(System.in);

    private static double getAvgReleasedAlbums(Singer[] singers) {
        return Arrays.stream(singers)
                .mapToInt(Singer::getReleasedAlbumsAmount)
                .average()
                .orElse(0);
    }

    public Singer getMostPopularSinger(Singer[] singers) {
        return Arrays.stream(singers)
                .max(Comparator.comparingInt(Singer::getRating))
                .orElseThrow(() -> new RuntimeException("Не найден подходящий объект"));
    }

    public Singer[] getSingersAboveAverageAlbums(Singer[] singers) {
        double averageAlbums = getAvgReleasedAlbums(singers);
        return Arrays.stream(singers)
                .filter(singer -> singer.getReleasedAlbumsAmount() > averageAlbums)
                .toArray(Singer[]::new);
    }

    public Singer findByName(Singer[] singers, String name) {
        return Arrays.stream(singers)
                .filter(singer -> singer.getArtistName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Не найден подходящий объект"));
    }

    public void sortByArtistNameDesc(Singer[] singers) {
        Arrays.sort(singers, Comparator.comparing(Singer::getArtistName).reversed());
    }

    public void editPersonInfoAndPrint() {
        out.println("Введите название для поиска объекта:");
        String nameToFind = scanner.nextLine();
        Singer singer = findByName(singers, nameToFind);
        out.println("Введите номер поля, требующего замены:");
        out.println("1 Имя артиста");
        out.println("2 Рейтинг");
        out.println("3 Количество выпущенных альбомов");
        int num = Integer.parseInt(scanner.nextLine());

        out.println("Введите новое значение поля:");
        String newValue = scanner.nextLine();
        switch (num) {
            case 1 -> singer.setArtistName(newValue);
            case 2 -> singer.setRating(Integer.parseInt(newValue));
            case 3 -> singer.setReleasedAlbumsAmount(Integer.parseInt(newValue));
            default -> throw new IllegalArgumentException("Неправильно введено значение номера поля");
        }
        out.println(singer);
    }
}
