package org.reliabschool.service;

import org.reliabschool.entity.Film;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static java.lang.System.out;

public class FilmService {

    public final Film[] films = {
            new Film("1", 1, "1", "1", 1),
            new Film("2", 2, "2", "2", 2),
            new Film("3", 3, "3", "3", 3),
            new Film("4", 4, "4", "4", 4),
            new Film("5", 5, "5", "5", 5),
    };

    public final Scanner scanner = new Scanner(System.in);

    public static Film[] getFilmsWithPriceMoreThanAverage(Film[] films) {
        double avgPrice = getAvgPrice(films);
        return Arrays.stream(films)
                .filter(film -> film.getPrice() > avgPrice)
                .toArray(Film[]::new);
    }

    private static double getAvgPrice(Film[] films) {
        return Arrays.stream(films)
                .mapToDouble(Film::getPrice)
                .average()
                .orElse(0);
    }

    public static Film getOldestFilm(Film[] films) {
        return Arrays.stream(films)
                .min(Comparator.comparing(Film::getYearOfPublication))
                .orElseThrow(() -> new RuntimeException("Не найден подходящий объект"));
    }

    public static void sortFilmsByName(Film[] films) {
        Arrays.sort(films, Comparator.comparing(Film::getName));
    }

    public static Film findByName(Film[] films, String name) {
        return Arrays.stream(films)
                .filter(film -> film.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Не найден подходящий объект"));
    }

    public void findAndEdit() {
        out.println("Введите название для поиска объекта:");
        String nameToFind = scanner.nextLine();
        Film film = findByName(films, nameToFind);


        out.println("Введите номер поля, требующего замены:");
        out.println("1 Название");
        out.println("2 Дата выпуска");
        out.println("3 Страна");
        out.println("4 Жанр");
        out.println("5 Цена");
        int num = Integer.parseInt(scanner.nextLine());

        out.println("Введите новое значение поля:");
        String newValue = scanner.nextLine();
        switch (num) {
            case 1 -> film.setName(newValue);
            case 2 -> film.setYearOfPublication(Integer.parseInt(newValue));
            case 3 -> film.setCountry(newValue);
            case 4 -> film.setGenre(newValue);
            case 5 -> film.setPrice(Integer.parseInt(newValue));
            default -> throw new IllegalArgumentException("Неправильно введено значение номера поля");
        }
        out.println(film);
    }
}
