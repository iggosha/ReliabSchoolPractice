package org.reliabschool.service;

import org.reliabschool.entity.Theatre;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static java.lang.System.out;

public class TheatreService {


    public final Theatre[] theatres = {
            new Theatre("1", "1", "1", 1),
            new Theatre("2", "2", "2", 1),
            new Theatre("3", "3", "3", 1),
            new Theatre("4", "4", "4", 1),
            new Theatre("5", "5", "5", 1),
    };

    public final Scanner scanner = new Scanner(System.in);


    public Theatre getHighestRatedTheatre(Theatre[] theatres) {
        return Arrays.stream(theatres)
                .max(Comparator.comparingInt(Theatre::getRating))
                .orElseThrow(() -> new RuntimeException("Не найден подходящий объект"));
    }


    public void sortTheatresByNameDesc(Theatre[] theatres) {
        Arrays.sort(theatres, Comparator.comparing(Theatre::getName).reversed());
    }


    public Theatre findByArtisticDirectorName(Theatre[] theatres, String artisticDirector) {
        return Arrays.stream(theatres)
                .filter(theatre -> theatre.getArtisticDirector().equalsIgnoreCase(artisticDirector))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Не найден подходящий объект"));
    }


    public void findAndEdit() {
        out.println("Введите название для поиска объекта:");
        String nameToFind = scanner.nextLine();
        Theatre theatre = findByArtisticDirectorName(theatres, nameToFind);
        out.println("Введите номер поля, требующего замены:");
        out.println("1 Название");
        out.println("2 Художественный руководитель");
        out.println("3 Адрес");
        out.println("4 Рейтинг");
        int num = Integer.parseInt(scanner.nextLine());

        out.println("Введите новое значение поля:");
        String newValue = scanner.nextLine();
        switch (num) {
            case 1 -> theatre.setName(newValue);
            case 2 -> theatre.setArtisticDirector(newValue);
            case 3 -> theatre.setAddress(newValue);
            case 4 -> theatre.setRating(Integer.parseInt(newValue));
            default -> throw new IllegalArgumentException("Неправильно введено значение номера поля");
        }
        out.println(theatre);
    }


    public Theatre[] getTheatresWithHigherRating(Theatre[] theatres, String theatreName) {
        Integer targetRating = findByName(theatres, theatreName).getRating();
        return Arrays.stream(theatres)
                .filter(theatre -> theatre.getRating() > targetRating)
                .toArray(Theatre[]::new);
    }


    private Theatre findByName(Theatre[] theatres, String name) {
        return Arrays.stream(theatres)
                .filter(theatre -> theatre.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Не найден подходящий объект"));
    }
}
