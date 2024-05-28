package org.reliabschool;

import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Function function = new Function();
        out.println("Введите значение X:");
        double x = scanner.nextDouble();

        out.println("Введите значение номер формулы для расчёта: ");

        switch (scanner.nextInt()) {
            case 1 -> out.println(function.f1(x));
            case 2 -> out.println(function.f2(x));
            case 3 -> out.println(function.f3(x));
            case 4 -> out.println(function.f4(x));
            case 5 -> out.println(function.f5(x));
            case 6 -> out.println(function.f6(x));
            case 7 -> out.println(function.f7(x));
            case 8 -> out.println(function.f8(x));
            case 9 -> out.println(function.f9(x));
            case 10 -> out.println(function.f10(x));
            case 11 -> out.println(function.f11(x));
            case 12 -> out.println(function.f12(x));
            case 13 -> out.println(function.f13(x));
            case 14 -> out.println(function.f14(x));
            case 15 -> out.println(function.f15(x));
            case 16 -> out.println(function.f16(x));
            default -> throw new IllegalArgumentException();
        }
    }
}