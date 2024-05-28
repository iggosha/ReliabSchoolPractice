package org.reliabschool;

import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Function function = new Function();

        out.print("Введите значение x: ");
        double x = scanner.nextDouble();

        out.print("Введите значение b: ");
        double b = scanner.nextDouble();

        out.print("Введите значение a: ");
        double a = scanner.nextDouble();

        out.print("Введите значение номер формулы для расчёта: ");
        int num = scanner.nextInt();
        out.print("Значение функции y = f(x): ");

        switch (num) {
            case 1 -> out.println(function.f1(x, b, a));
            case 2 -> out.println(function.f2(x, b, a));
            case 3 -> out.println(function.f3(x, b, a));
            case 4 -> out.println(function.f4(x, b, a));
            case 5 -> out.println(function.f5(x, b, a));
            case 6 -> out.println(function.f6(x, b, a));
            case 7 -> out.println(function.f7(x, b, a));
            case 8 -> out.println(function.f8(x, b, a));
            case 9 -> out.println(function.f9(x, b, a));
            case 10 -> out.println(function.f10(x, b, a));
            case 11 -> out.println(function.f11(x, b, a));
            case 12 -> out.println(function.f12(x, b, a));
            case 13 -> out.println(function.f13(x, b, a));
            case 14 -> out.println(function.f14(x, b, a));
            case 15 -> out.println(function.f15(x, b, a));
            case 16 -> out.println(function.f16(x, b, a));
            default -> throw new IllegalArgumentException();
        }
    }
}