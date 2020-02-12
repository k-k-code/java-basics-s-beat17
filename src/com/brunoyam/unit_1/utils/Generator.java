package com.brunoyam.unit_1.utils;

import java.util.Random;

/*
Это служебный клас который просто генерирует массивы и заполняет их данными.
 */
public abstract class Generator {

    public static int[] getOneDimensionArray() {
        Random random = new Random();

        int arraySize = random.nextInt(98) + 3;

        int[] oneDimensionArray = new int[arraySize];
        for(int i = 0; i < oneDimensionArray.length; i++) {
            oneDimensionArray[i] = random.nextInt();
        }

        int negativePosition = random.nextInt(arraySize);
        while (oneDimensionArray[negativePosition] >= 0) {
            oneDimensionArray[negativePosition] = random.nextInt();
        }

        int positivePosition = random.nextInt(arraySize);
        while (positivePosition == negativePosition) {
            positivePosition = random.nextInt(arraySize);
        }
        while (oneDimensionArray[positivePosition] <= 0) {
            oneDimensionArray[positivePosition] = random.nextInt();
        }

        int zeroPozition = random.nextInt(arraySize);
        while (zeroPozition == positivePosition || zeroPozition == negativePosition) {
            zeroPozition = random.nextInt(arraySize);
        }
        oneDimensionArray[zeroPozition] = 0;

        return oneDimensionArray;
    }

    public static int[][] getTwoDimensionsArray() {
        Random random = new Random();

        int[][] twoDimensionsArray = new int[random.nextInt(96) + 5][random.nextInt(6) + 5];
        for(int i = 0; i < twoDimensionsArray.length; i++) {
            for(int j = 0; j < twoDimensionsArray[i].length; j++) {
                twoDimensionsArray[i][j] = random.nextInt();
            }
        }

        return twoDimensionsArray;
    }

}
