package org.reliabschool;


import static java.lang.Math.*;

public class Function {

    double sum = 0; // инициализация суммы
    double an = 1; // инициализация значения первого слагаемого (переопределяется)
    double accuracy = 1e-10; // точность вычисления

    private int factorial(int n) {
        return (n < 2) ? 1 : n * factorial(n - 1);
    }

    private void throwSumOverflowError() {
        throw new StackOverflowError("Превышено максимальное значение суммы (бесконечность)");
    }

    private void throwWrongXExc() {
        throw new IllegalArgumentException("X не принадлежит заданному по условию интервалу");
    }

    private double calculateArithmeticProgression(int nTerms) {
        double result = 0.0;
        for (int i = 1; i <= nTerms; i++) {
            result += 1.0 / i;
        }
        return result;
    }

    private void addAnToSumAndCheckExceptions() {
        if (abs(an) >= Double.MAX_VALUE) throwSumOverflowError();
        sum += an;
        if (abs(sum) >= Double.MAX_VALUE) throwSumOverflowError();
    }


    public double f1(double x) {
        for (int n = 1; Math.abs(an) > accuracy; n++) {
            an = pow(-1, n) * (2 * n * pow(x, 2 * n + 1.0) / factorial(2 * n + 1));
            addAnToSumAndCheckExceptions();
        }
        return sum;
    }

    public double f2(double x) {
        if (x <= -1 || x >= 1) throwWrongXExc();
        for (int n = 0; Math.abs(an) > accuracy; n++) {
            an = pow(x, 2 * n + 1.0) / (2 * n + 1);
            addAnToSumAndCheckExceptions();
        }
        return sum;
    }

    public double f3(double x) {
        if (x <= -1 || x >= 1) throwWrongXExc();
        for (int n = 0; Math.abs(an) > accuracy; n++) {
            an = pow(x, 4 * n + 1.0) / (4 * n + 1);
            addAnToSumAndCheckExceptions();
        }
        return sum;
    }

    public double f4(double x) {
        for (int n = 0; Math.abs(an) > accuracy; n++) {
            an = pow(2, n / 2.0) * cos(PI * n / 4) * pow(x, n) / factorial(n);
            addAnToSumAndCheckExceptions();
        }
        return sum;
    }

    public double f5(double x) {
        for (int n = 0; Math.abs(an) > accuracy; n++) {
            an = pow(2, n / 2.0) * sin(PI * n / 4) * pow(x, n) / factorial(n);
            addAnToSumAndCheckExceptions();
        }
        return sum;
    }

    public double f6(double x) {
        for (int n = 2; Math.abs(an) > accuracy; n++) {
            an = pow(-1, n + 1.0) * (n - 1) * pow(x, n) / factorial(n);
            addAnToSumAndCheckExceptions();
        }
        return 1 + sum;
    }

    public double f7(double x) {
        return f1(x);
    }

    public double f8(double x) {
        return f1(x);
    }

    public double f9(double x) {
        if (x < -1 || x >= 1) throwWrongXExc();
//        for (int n = 1; Math.abs(an) > accuracy; n++) {
//            an = calculateArithmeticProgression(n) * (pow(x, n + 1.0) / n + 1);
//            addAnToSumAndCheckExceptions();
//            System.out.println(sum);
//        }
        //долго считает (точно более 10 сек), постоянно прибавляя значения ~1000
        throwSumOverflowError();
        return 2 * sum;
    }

    public double f10(double x) {
        if (x <= -1 || x >= 1) throwWrongXExc();
        for (int n = 1; Math.abs(an) > accuracy; n++) {
            an = pow(-1, n - 1.0) * calculateArithmeticProgression(n) * pow(x, n);
            addAnToSumAndCheckExceptions();
        }
        return 2 * sum;
    }


    public double f11(double x) {
        if (x <= -1 || x >= 1) throwWrongXExc();
        for (int n = 0; Math.abs(an) > accuracy; n++) {
            an = factorial(factorial(2 * n + 1)) * pow(x, 2.0 * n) / factorial(factorial(2 * n));
            addAnToSumAndCheckExceptions();
        }
        return sum;
    }

    public double f12(double x) {
        if (x < -0.25 || x > 0.5) throwWrongXExc();
        for (int n = 1; Math.abs(an) > accuracy; n++) {
            an = pow(-1, n) * pow(2, 2 * n - 1.0) * pow(x, 2 * n - 1.0) / (2 * n - 1);
            addAnToSumAndCheckExceptions();
        }
        return atan(2) + sum;
    }

    public double f13(double x) {
        if (x < -1 || x > 1) throwWrongXExc();
        for (int n = 1; Math.abs(an) > accuracy; n++) {
            an = pow(-1, n + 1.0) * (pow(x, 2.0 * n) / (2 * n * (2 * n - 1)));
            addAnToSumAndCheckExceptions();
        }
        return sum;
    }

    public double f14(double x) {
        if (x < -1 || x > 1) throwWrongXExc();
        for (int n = 0; Math.abs(an) > accuracy; n++) {
            an = pow(-1, n) * (pow(x, 2.0 * n + 1.0) * (1 + pow(x, 2)) / (2 * n + 1));
            addAnToSumAndCheckExceptions();
        }
        return sum;
    }

    public double f15(double x) {
        if (x < -1 || x > 1) throwWrongXExc();
        for (int n = 1; Math.abs(an) > accuracy; n++) {
            an = pow(-1, n - 1.0) * (pow(x, n) * (1 + x) / n);
            addAnToSumAndCheckExceptions();
        }
        return sum;
    }

    public double f16(double x) {
        if (x < -1 || x > 1) throwWrongXExc();
        for (int n = 0; Math.abs(an) > accuracy; n++) {
            an = pow(-1, n) * pow(x, 2.0 * n + 1.0) / (4 * pow(n, 2) - 1.0);
            addAnToSumAndCheckExceptions();
        }
        return x + 2 * sum;
    }

}
