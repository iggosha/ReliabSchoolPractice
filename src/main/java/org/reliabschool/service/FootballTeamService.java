package org.reliabschool.service;

import org.reliabschool.entity.FootballTeam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static java.lang.System.out;

public class FootballTeamService {

    public final FootballTeam[] footballTeams = {
            new FootballTeam("1", "1", 1, 1),
            new FootballTeam("2", "2", 2, 2),
            new FootballTeam("3", "3", 3, 3),
            new FootballTeam("4", "4", 4, 4),
            new FootballTeam("5", "5", 5, 5),
    };

    public final Scanner scanner = new Scanner(System.in);

    private static double getAvgVictories(FootballTeam[] teams) {
        return Arrays.stream(teams)
                .mapToInt(FootballTeam::getVictoriesNum)
                .average()
                .orElse(0);
    }

    public FootballTeam getTeamWithMostVictories(FootballTeam[] teams) {
        return Arrays.stream(teams)
                .max(Comparator.comparingInt(FootballTeam::getVictoriesNum))
                .orElseThrow(() -> new RuntimeException("Не найден подходящий объект"));
    }

    public FootballTeam[] getTeamsAboveAverageVictories(FootballTeam[] teams) {
        double avgVictories = getAvgVictories(teams);
        return Arrays.stream(teams)
                .filter(team -> team.getVictoriesNum() > avgVictories)
                .toArray(FootballTeam[]::new);
    }

    public void sortByLeaguePositionDescending(FootballTeam[] teams) {
        Arrays.sort(teams, Comparator.comparing(FootballTeam::getLeaguePosition).reversed());
    }


    public FootballTeam findByName(FootballTeam[] teams, String name) {
        return Arrays.stream(teams)
                .filter(team -> team.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Не найден подходящий объект"));
    }

    public void findAndEdit() {
        out.println("Введите название для поиска объекта:");
        String nameToFind = scanner.nextLine();
        FootballTeam footballTeam = findByName(footballTeams, nameToFind);


        out.println("Введите номер поля, требующего замены:");
        out.println("1 Название");
        out.println("2 Город");
        out.println("3 Место в лиге");
        out.println("4 Количество побед");
        int num = Integer.parseInt(scanner.nextLine());

        out.println("Введите новое значение поля:");
        String newValue = scanner.nextLine();
        switch (num) {
            case 1 -> footballTeam.setName(newValue);
            case 2 -> footballTeam.setCity(newValue);
            case 3 -> footballTeam.setLeaguePosition(Integer.parseInt(newValue));
            case 4 -> footballTeam.setVictoriesNum(Integer.parseInt(newValue));
            default -> throw new IllegalArgumentException("Неправильно введено значение номера поля");
        }
        out.println(footballTeam);
    }
}
