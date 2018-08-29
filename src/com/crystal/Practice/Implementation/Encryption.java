package com.crystal.Practice.Implementation;

import java.util.Arrays;

public class Encryption {

    public static void main (String args []) {

        String input = "haveaniceday";
        System.out.println(encrypt(input));

    }

    static String encrypt(String decryptedInput) {

        char[] characterArray = decryptedInput.toCharArray();
        int count = characterArray.length;

        Double squareRoot = Math.sqrt(decryptedInput.length());
        int columns = (int) Math.ceil(squareRoot);
        int rows = (int) Math.floor(squareRoot);

        if ((rows * columns) < count) {
            double minimum = Math.min(rows, columns);
            if (minimum == rows) {
                rows++;
            } else {
                columns++;
            }
        }

        char[][] encryptedGrid = new char[rows][columns];
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (k < count) {
                    encryptedGrid[i][j] = decryptedInput.charAt(k);
                    k++;
                }
            }
        }

        System.out.println(Arrays.deepToString(encryptedGrid));

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                answer.append(encryptedGrid[j][i]);
            }
            if (!(i < columns)) {
                answer.append(" ");
            }
        }

        return answer.toString();

    }

}
