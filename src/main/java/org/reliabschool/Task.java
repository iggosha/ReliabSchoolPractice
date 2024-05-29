package org.reliabschool;

import java.util.Scanner;

import static java.lang.System.out;

public class Task {

    TaskOperation taskOperation = new TaskOperation();
    MyArrayUtils arrayUtils = new MyArrayUtils();

    Scanner scanner = new Scanner(System.in);


    public void task1() {
        arrayUtils.askToInput3ArraysSizes();
        Integer[] a = arrayUtils.getRandomIntArray(scanner.nextInt());
        Integer[] b = arrayUtils.getRandomIntArray(scanner.nextInt());
        Integer[] c = arrayUtils.getRandomIntArray(scanner.nextInt());
        arrayUtils.outputArrays(a, b, c);

        out.println("Минимальный элемент массива a: " + taskOperation.getMin(a));
        out.println("Минимальный элемент массива b: " + taskOperation.getMin(b));
        out.println("Минимальный элемент массива c: " + taskOperation.getMin(c));
    }


    public void task2() {
        arrayUtils.askToInput3ArraysSizes();
        Double[] a = arrayUtils.getRandomDoubleArray(scanner.nextInt());
        Double[] b = arrayUtils.getRandomDoubleArray(scanner.nextInt());
        Double[] c = arrayUtils.getRandomDoubleArray(scanner.nextInt());
        arrayUtils.outputArrays(a, b, c);

        out.println("Максимальный элемент массива a: " + taskOperation.getMax(a));
        out.println("Максимальный элемент массива b: " + taskOperation.getMax(b));
        out.println("Максимальный элемент массива c: " + taskOperation.getMax(c));
    }

    public void task3() {
        arrayUtils.askToInput3ArraysSizes();
        Double[] a = arrayUtils.getRandomDoubleArray(scanner.nextInt());
        Double[] b = arrayUtils.getRandomDoubleArray(scanner.nextInt());
        Double[] c = arrayUtils.getRandomDoubleArray(scanner.nextInt());
        arrayUtils.outputArrays(a, b, c);

        out.println("Индекс минимального элемента массива a: " + taskOperation.getIndexMin(a));
        out.println("Индекс минимального элемента массива b: " + taskOperation.getIndexMin(b));
        out.println("Индекс минимального элемента массива c: " + taskOperation.getIndexMin(c));

        out.println("Индекс максимального элемента массива a: " + taskOperation.getIndexMax(a));
        out.println("Индекс максимального элемента массива b: " + taskOperation.getIndexMax(b));
        out.println("Индекс максимального элемента массива c: " + taskOperation.getIndexMax(c));
    }


    public void task4() {
        arrayUtils.askToInput3ArraysSizes();
        Double[] a = arrayUtils.getRandomDoubleArray(scanner.nextInt());
        Double[] b = arrayUtils.getRandomDoubleArray(scanner.nextInt());
        Double[] c = arrayUtils.getRandomDoubleArray(scanner.nextInt());
        arrayUtils.outputArrays(a, b, c);
        a = taskOperation.getInvertedArray(a);
        b = taskOperation.getInvertedArray(b);
        c = taskOperation.getInvertedArray(c);
        out.println("Массивы после инвертирования: ");
        arrayUtils.outputArrays(a, b, c);
    }

    public void task5() {
        arrayUtils.askToInputArraySize();
        Double[] a = arrayUtils.getRandomDoubleArray(scanner.nextInt());
        arrayUtils.outputArray(a);
        a = taskOperation.smoothArrayVar5(a);
        out.println("Массив после сглаживания: ");
        arrayUtils.outputArray(a);
    }

    public void task6() {
        arrayUtils.askToInputArraySize();
        Double[] a = arrayUtils.getRandomDoubleArray(scanner.nextInt());
        arrayUtils.outputArray(a);
        taskOperation.smoothArrayVar6(a);
    }

    public void task7() {
        arrayUtils.askToInputArraySize();
        Double[] a = arrayUtils.getRandomDoubleArray(scanner.nextInt());
        out.println("Массивы после удаления заданных чисел: ");
        arrayUtils.outputArray(a);
        taskOperation.smoothArrayVar7(a);

    }

    public void task8() {
        arrayUtils.askToInput3ArraysSizes();
        Integer[] a = arrayUtils.getRandomIntArray(scanner.nextInt());
        Integer[] b = arrayUtils.getRandomIntArray(scanner.nextInt());
        Integer[] c = arrayUtils.getRandomIntArray(scanner.nextInt());
        arrayUtils.outputArrays(a, b, c);

        arrayUtils.askToInputNum();
        a = taskOperation.removeElementsEqualTo(a, scanner.nextInt());
        arrayUtils.askToInputNum();
        b = taskOperation.removeElementsEqualTo(b, scanner.nextInt());
        arrayUtils.askToInputNum();
        c = taskOperation.removeElementsEqualTo(c, scanner.nextInt());

        out.println("Массивы после удаления заданных чисел: ");

        arrayUtils.outputArrays(a, b, c);
        arrayUtils.outputArraysSizes(a, b, c);

    }

    public void task9() {
        arrayUtils.askToInput3ArraysSizes();
        Double[] a = arrayUtils.getRandomDoubleArray(scanner.nextInt());
        Double[] b = arrayUtils.getRandomDoubleArray(scanner.nextInt());
        Double[] c = arrayUtils.getRandomDoubleArray(scanner.nextInt());
        arrayUtils.outputArrays(a, b, c);

        a = taskOperation.removeExcessElements(a);
        b = taskOperation.removeExcessElements(b);
        c = taskOperation.removeExcessElements(c);

        out.println("Массивы после удаления 'лишних' чисел: ");

        arrayUtils.outputArrays(a, b, c);
        arrayUtils.outputArraysSizes(a, b, c);
    }

    public void task10() {
        arrayUtils.askToInput3ArraysSizes();
        Integer[] a = arrayUtils.getRandomIntArray(scanner.nextInt());
        Integer[] b = arrayUtils.getRandomIntArray(scanner.nextInt());
        Integer[] c = arrayUtils.getRandomIntArray(scanner.nextInt());
        arrayUtils.outputArrays(a, b, c);

        arrayUtils.askToInputNum();
        a = taskOperation.duplicateElementsEqualTo(a, scanner.nextInt());
        arrayUtils.askToInputNum();
        b = taskOperation.duplicateElementsEqualTo(b, scanner.nextInt());
        arrayUtils.askToInputNum();
        c = taskOperation.duplicateElementsEqualTo(c, scanner.nextInt());

        out.println("Массивы после дублирования заданных чисел: ");

        arrayUtils.outputArrays(a, b, c);
        arrayUtils.outputArraysSizes(a, b, c);

    }

    public void task11() {
        arrayUtils.askToInput3ArraysSizes();
        Double[] a = arrayUtils.getRandomDoubleArray(scanner.nextInt());
        Double[] b = arrayUtils.getRandomDoubleArray(scanner.nextInt());
        Double[] c = arrayUtils.getRandomDoubleArray(scanner.nextInt());
        arrayUtils.outputArrays(a, b, c);

        a = taskOperation.quickSort(a, 0, a.length - 1);
        b = taskOperation.quickSort(b, 0, b.length - 1);
        c = taskOperation.quickSort(c, 0, c.length - 1);
        out.println("Массивы после сортировки: ");

        arrayUtils.outputArrays(a, b, c);
    }

    public void task12() {
        arrayUtils.askToInput3ArraysSizes();
        Double[] a = arrayUtils.getRandomDoubleArray(scanner.nextInt());
        Double[] b = arrayUtils.getRandomDoubleArray(scanner.nextInt());
        Double[] c = arrayUtils.getRandomDoubleArray(scanner.nextInt());
        arrayUtils.outputArrays(a, b, c);

        Integer[] aIndexes = taskOperation.sortIndexes(a);
        Integer[] bIndexes = taskOperation.sortIndexes(b);
        Integer[] cIndexes = taskOperation.sortIndexes(c);
        out.println("Массивы индексов после сортировки: ");

        arrayUtils.outputArrays(aIndexes, bIndexes, cIndexes);
    }

    public void task13() {
        arrayUtils.askToInput3ArraysSizes();
        Double[] a = arrayUtils.getRandomDoubleArray(scanner.nextInt());
        Double[] b = arrayUtils.getRandomDoubleArray(scanner.nextInt());
        Double[] c = arrayUtils.getRandomDoubleArray(scanner.nextInt());
        arrayUtils.outputArrays(a, b, c);

        a = taskOperation.bellOrder(a);
        b = taskOperation.bellOrder(b);
        c = taskOperation.bellOrder(c);
        out.println("Массивы в порядке 'колокола': ");

        arrayUtils.outputArrays(a, b, c);

    }

    public void task14() {
        arrayUtils.askToInputArraySize();
        Double[] a = arrayUtils.getRandomDoubleArray(scanner.nextInt());
        arrayUtils.outputArray(a);
        taskOperation.splitArrayByIndexes(a);

    }

    public void task15() {
        arrayUtils.askToInputArraySize();
        Integer[] a = arrayUtils.getRandomIntArray(scanner.nextInt());
        arrayUtils.outputArray(a);
        taskOperation.splitArrayByIndexes(a);
    }
}
