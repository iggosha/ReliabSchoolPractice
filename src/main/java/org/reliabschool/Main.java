package org.reliabschool;

import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Task task = new Task();
        out.println("Введите значение номер задания: ");
        int num = scanner.nextInt();
        switch (num) {
            case 1 -> task.task1();
            case 2 -> task.task2();
            case 3 -> task.task3();
            case 4 -> task.task4();
            case 5 -> task.task5();
            case 6 -> task.task6();
            case 7 -> task.task7();
            case 8 -> task.task8();
            case 9 -> task.task9();
            case 10 -> task.task10();
            case 11 -> task.task11();
            case 12 -> task.task12();
            case 13 -> task.task13();
            case 14 -> task.task14();
            case 15 -> task.task15();
            default -> throw new IllegalArgumentException();
        }
    }
}
