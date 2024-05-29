package org.reliabschool;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class MyArrayUtils {

    Random random = new Random();

    public void askToInput3ArraysSizes() {
        out.println("Введите 3 размера массивов");

    }

    public void askToInputArraySize() {
        out.println("Введите размер массива");
    }

    public void askToInputNum() {
        out.println("Введите число");
    }

    @SafeVarargs
    public final <T extends Number & Comparable<T>> void outputArrays(T[]... arrays) {
        out.println();
        for (int i = 0; i < arrays.length; i++) {
            out.println((i + 1) + " массив: " + Arrays.toString(arrays[i]));
        }
    }

    @SafeVarargs
    public final <T extends Number & Comparable<T>> void outputArraysSizes(T[]... arrays) {
        out.println();
        for (int i = 0; i < arrays.length; i++) {
            out.println("Размер массива " + (i + 1) + ": " + arrays[i].length);
        }
    }

    public <T extends Number & Comparable<T>> void outputArray(T[] array) {
        out.println();
        out.println("Массив: " + Arrays.toString(array));
    }


    public Integer[] getRandomIntArray(int size) {
        return IntStream.generate(() -> random.nextInt(100))
                .limit(size)
                .boxed()
                .toArray(Integer[]::new);
    }

    public Double[] getRandomDoubleArray(int size) {
        return DoubleStream.generate(() -> random.nextDouble(100))
                .limit(size)
                .boxed()
                .toArray(Double[]::new);
    }

}
