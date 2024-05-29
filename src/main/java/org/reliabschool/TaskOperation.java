package org.reliabschool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TaskOperation {

    MyArrayUtils arrayUtils = new MyArrayUtils();

    public <T extends Number & Comparable<T>> Integer[] sortIndexes(T[] array) {
        Integer[] indexes = new Integer[array.length];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;
        }

        if (array[0] instanceof Integer) {
            Comparator<Integer> indexComparator = Comparator.comparingInt(i -> (Integer) array[i]);
            Arrays.sort(indexes, indexComparator);
        } else {
            Comparator<Integer> indexComparator = Comparator.comparingDouble(i -> (Double) array[i]);
            Arrays.sort(indexes, indexComparator);
        }
        return indexes;
    }

    public <T extends Number & Comparable<T>> T[] bellOrder(T[] array) {
        int start = 0;
        int end = array.length - 1;
        array = quickSort(array, start, end);
        T[] tempArray;
        if (array[0] instanceof Double) {
            tempArray = (T[]) new Double[array.length];
        } else {
            tempArray = (T[]) new Integer[array.length];
        }
        boolean orderFlag = true;
        for (T element : array) {
            if (orderFlag) {
                tempArray[start++] = element;
            } else {
                tempArray[end--] = element;
            }
            orderFlag = !orderFlag;
        }
        array = tempArray;
        return array;
    }

    public <T extends Number & Comparable<T>> T[] quickSort(T[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
        return array;
    }

    private <T extends Number & Comparable<T>> int partition(T[] array, int low, int high) {
        T pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        T temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    public <T extends Number & Comparable<T>> T getMin(T[] array) {
        T min = array[0];
        if (array.length == 1) return min;
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(min) < 0) {
                min = array[i];
            }
        }
        return min;
    }

    public <T extends Number & Comparable<T>> T getMax(T[] array) {
        T max = array[0];
        if (array.length == 1) return max;
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }

    public <T extends Number & Comparable<T>> int getIndexMin(T[] array) {
        int indexMin = 0;
        if (array.length == 1) return indexMin;
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(array[indexMin]) < 0) {
                indexMin = i;
            }
        }
        return indexMin;
    }

    public <T extends Number & Comparable<T>> int getIndexMax(T[] array) {
        int indexMax = 0;
        if (array.length == 1) return indexMax;
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(array[indexMax]) > 0) {
                indexMax = i;
            }
        }
        return indexMax;
    }

    public <T extends Number & Comparable<T>> T[] getInvertedArray(T[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            T temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }

    public Double[] smoothArrayVar5(Double[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            array[i] = sum / (i + 1);
        }
        return array;
    }

    public Double[] smoothArrayVar6(Double[] array) {
        for (int i = 0; i < 5; i++) {
            Double[] originalArray = array.clone();
            for (int j = 1; j < array.length; j++) {
                array[j] = (originalArray[j - 1] + originalArray[j]) / 2;
            }
            System.out.println((i + 1) + " сглаживание: ");
            arrayUtils.outputArray(array);
        }
        return array;
    }

    public Double[] smoothArrayVar7(Double[] array) {
        for (int i = 0; i < 5; i++) {
            Double[] originalArray = array.clone();
            for (int j = 0; j < array.length; j++) {
                if (j > 0 && j < array.length - 1) {
                    array[j] = (originalArray[j - 1] + originalArray[j] + originalArray[j + 1]) / 3;
                } else {
                    array[j] = originalArray[j];
                }
            }
            System.out.println((i + 1) + " сглаживание: ");
            arrayUtils.outputArray(array);
        }
        return array;
    }

    public <T extends Number & Comparable<T>> T[] removeElementsEqualTo(T[] array, T numToRemove) {
        List<T> resultList = new ArrayList<>();
        for (T element : array) {
            if (element.compareTo(numToRemove) != 0) {
                resultList.add(element);
            }
        }
        return mapTListToArray(resultList);
    }

    public <T extends Number & Comparable<T>> T[] duplicateElementsEqualTo(T[] array, T numToDuplicate) {
        List<T> resultList = new ArrayList<>();
        for (T element : array) {
            resultList.add(element);
            if (element.compareTo(numToDuplicate) == 0) {
                resultList.add(element);
            }
        }
        return mapTListToArray(resultList);
    }

    public <T extends Number & Comparable<T>> T[] removeExcessElements(T[] array) {
        List<T> resultList = new ArrayList<>();
        resultList.add(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(resultList.getLast()) > 0) {
                resultList.add(array[i]);
            }
        }
        return mapTListToArray(resultList);
    }

    public <T extends Number & Comparable<T>> void splitArrayByIndexes(T[] array) {
        List<T> listB = new ArrayList<>();
        List<T> listC = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                listB.add(array[i]);
            } else {
                listC.add(array[i]);
            }
        }
        T[] arrayB = mapTListToArray(listB);
        T[] arrayC = mapTListToArray(listC);
        arrayUtils.outputArrays(arrayB, arrayC);
        arrayUtils.outputArraysSizes(arrayB, arrayC);
    }

    private <T extends Number & Comparable<T>> T[] mapTListToArray(List<T> list) {
        if (list.getFirst() instanceof Integer) {
            return (T[]) list.stream().mapToInt(i -> (Integer) i).boxed().toArray(Integer[]::new);
        } else {
            return (T[]) list.stream().mapToDouble(i -> (Double) i).boxed().toArray(Double[]::new);
        }
    }


//    <T extends Number & Comparable<T>>
//    T[]
}