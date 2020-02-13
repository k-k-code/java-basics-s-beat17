package com.brunoyam.unit_1;

import com.brunoyam.unit_1.utils.Generator;

import java.util.Arrays;

public class Main {

    /*
    Условия:
    oneDimensionArray - массив содержащий не меньше 3 и не больше 99 элементов типа int.
    Среди них всегда есть хотя бы одно положительное, хотя бы одно отрицательное и хотя бы один 0.

    twoDimensionsArray - двумерный массив типа int. Представляет матрицу, содержащую не менее 5 и не более 100 столбцов, и не менее 5, но не более 10 строк.

    Подсказки:

    Для выполнения задания вспомните максимальные и минимальные значения целочисленных типов.

    Длина массива хранится в поле length. Например, длину массива myArray можно получить так: int myArrayLength = myArray.length

    Для выходя из метода используется ключевое слово return. Если после него стоит значение (или переменная), то это значение будет возвращено как результат работы метода.

    Метод main расположен последним в классе (находится в самом низу)

     */

    private static int[] oneDimensionArray = Generator.getOneDimensionArray();

    private static void level1() {
        /*
         Выберите подходящий тип переменных, в которые будут сохраняться значения.
         Не забудьте, что метод, вычисляющий значение переменной должен возвращать тот же тип.
        */
        int minValue = findMinValue(oneDimensionArray);
        int maxValue = findMaxValue(oneDimensionArray);
        long sumOfValues = sumValues(oneDimensionArray);
        int firstPositiveIndex = getFirstPositiveIndex(oneDimensionArray);
        int firstNegativeIndex = getFirstNegativeIndex(oneDimensionArray);


        System.out.println("First part");

        System.out.println("min: " + minValue);
        System.out.println("max: " + maxValue);
        System.out.println("sum: " + sumOfValues);

        System.out.println();
        System.out.println("length: " + oneDimensionArray.length);
        System.out.println("first positive index: " + firstPositiveIndex);
        System.out.println("first negative index: " + firstNegativeIndex);
    }

    private static void level2() {

        /*
         Выберите подходящий тип переменных, в которые будут сохраняться значения.
         Не забудьте, что метод должен возвращать значение тогот же типа.
        */
        int lastPositiveIndex = getLastPositiveIndex(oneDimensionArray);
        int lastNegativeIndex = getLastNegativeIndex(oneDimensionArray);
        byte[] positiveNegativeNumber = countPositiveNegative(oneDimensionArray);

        System.out.println(Arrays.toString(oneDimensionArray));
        System.out.println();
        System.out.println("last positive index: " + lastPositiveIndex);
        System.out.println("last negative index: " + lastNegativeIndex);
        System.out.println("total positives: " + positiveNegativeNumber[0]);
        System.out.println("total negatives: " + positiveNegativeNumber[1]);
    }

    private static void level3() {
        int[][] twoDimensionsArray = Generator.getTwoDimensionsArray();
        long[] arrayOfSums = sumSubArrays(twoDimensionsArray);

        System.out.println();
        System.out.println("Second part");
        System.out.println("result: " + Arrays.toString(arrayOfSums));

        sort(oneDimensionArray);

        System.out.println();
        for(int value : oneDimensionArray) {
            System.out.print(value + " ");
        }
    }

    /* Укажите тип значения, которое будет возвращать метод*/
    private static int findMinValue(int[] arrayOfValues) {
        /* Укажите тип переменной */
        int minValue = arrayOfValues[0];
        /*
           Используя цикл for переберите все значения массива и сохраните минимальное в переменную minValue.
         */
        for(int i = 0; i < arrayOfValues.length; i++) {
            if (arrayOfValues[i] < minValue) {
                minValue = arrayOfValues[i];
            }
        }
        return minValue;
    }

    /* Укажите тип значения, которое будет возвращать метод*/
    private static int findMaxValue(int[] arrayOfValues) {
        /* Укажите тип переменной */
        int maxValue = arrayOfValues[0];
        /*
           Используя цикл for переберите все значения массива и сохраните максимальное в переменную maxValue.
         */
        for(int i = 0; i < arrayOfValues.length; i++) {
            if (arrayOfValues[i] > maxValue) {
                maxValue = arrayOfValues[i];
            }
        }
        return maxValue;
    }

    /* Укажите тип значения, которое будет возвращать метод*/
    private static int sumValues(int[] arrayOfValues) {
        /* Укажите тип переменной */
        int sum = 0;
        /* Используя цикл for переберите все значения массива, просуммируйте и сохраните сумму всех значений в переменную sum. */
        for(int i = 0; i < arrayOfValues.length; i++) {
            sum += arrayOfValues[i];
        }
        return sum;
    }

    /* Укажите тип значения, которое будет возвращать метод*/
    private static int getFirstPositiveIndex(int[] arrayOfValues) {
        /* Укажите тип переменной */
        int firstPositiveIndex = 0;
        /* Используя цикл while найдите индекс первого положительного значения в массиве и сохраните в переменную firstPositiveIndex */
        int i = 0;

        while (arrayOfValues[i] < 0) {
            i++;
        }
        firstPositiveIndex = arrayOfValues[i];

        return firstPositiveIndex;
    }

    /* Укажите тип значения, которое будет возвращать метод*/
    private static int getFirstNegativeIndex(int[] arrayOfValues) {
        /* Укажите тип переменной */
        int firstNegativeIndex = 0;
        /* Используя цикл while найдите первое отрицательное значение и сохраните в переменную firstNegativeIndex */
        int i = 0;

        while (arrayOfValues[i] > 0) {
            i++;
        }
        firstNegativeIndex = arrayOfValues[i];

        return firstNegativeIndex;
    }

    /* Укажите тип значения, которое будет возвращать метод*/
    private static int getLastPositiveIndex(int[] arrayOfValues) {
        /*
        Найдите последнее положительное значение в массиве.
        Верните найденное значение используя ключевое слово return.
         */
        int finishPositiveValue = 0;
        int i = arrayOfValues.length;

        do {
            i--;
            finishPositiveValue = arrayOfValues[i];
        } while (arrayOfValues[i] < 0);
        return finishPositiveValue;
    }

    /* Укажите тип значения, которое будет возвращать метод*/
    private static int getLastNegativeIndex(int[] arrayOfValues) {
        /*
        Найдите последнее отрицательное значение в массиве.
        Верните найденное значение используя ключевое слово return.
         */
        int finishNegativeValue = 0;
        int i = arrayOfValues.length;

        do {
            i--;
            finishNegativeValue = arrayOfValues[i];
        } while (arrayOfValues[i] > 0);
        return finishNegativeValue;
    }

    private static byte[] countPositiveNegative(int[] arrayOfValues) {
        byte[] result = new byte[2];

        /*
        Посчитайте количество положительных и отрицательных значений в массиве arrayOfValues.
        Результат сохраните в массив result:
            В первый элемент - количество положительных
            Во второй элемент - количество отрицательных
         */
        byte countPositive = 0;
        byte countNegative = 0;

        for(int i = 0; i < arrayOfValues.length; i++) {
            if(arrayOfValues[i] > 0) {
                countPositive++;
                result[0] = countPositive;
            } else {
                countNegative++;
                result[1] = countNegative;
            }
        }
        return result;
    }

    private static long[] sumSubArrays(int[][] arrayOfValues) {
        /*
        Объявите массив типа long, сохраните в него результат сложения значений во всех столбцах матрицы arrayValues.
        Например, если arrayValues:

        3 1 3
        2 4 3
        5 4 2

        То полученный массив должен содержать суммы значений для каждого столбца:
        10 9 8

        Верните полученный массив используя ключевое слово return.
         */
        long[] columnSum = new long[arrayOfValues[0].length];
        for (int col = 0; col < arrayOfValues[0].length; col++) {
            long sum = 0;
            for(int row = 0; row < arrayOfValues.length; row++) {
                sum += arrayOfValues[row][col];
            }
            columnSum[col] = sum;
        }
        return columnSum;
    }

    private static void sort(int[] array) {
        //Отсортируйте массив array с помощью алгоритма "сортировки выбором".
        for(int i = 0; i < array.length; i++) {
            int min = i;
            for(int j = i; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int tmp = array[i];
            array[i] = array[min];
            array[min] = tmp;
        }
    }

    public static void main(String[] args) {
        level1();
        level2();
        level3();
    }

}
