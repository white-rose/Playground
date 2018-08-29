package com.crystal.Practice.Implementation;

import java.util.Arrays;

public class TheGridSearch {

    public static void main (String ... args) {

        String[] g = {
                "7283455864",
                "6731158619",
                "8988242643",
                "3830589324",
                "2229505813",
                "5633845374",
                "6473530293",
                "7053106601",
                "0834282956",
                "4607924137"
        };

        String[] p = {
                "9505",
                "3845",
                "3530"
        };

        gridSearch(g, p);

    }

    static String gridSearch(String[] g, String[] p) {

        boolean found = false;

        int colmP = p[0].length();
        int rowsP = p.length;
        char[][] gridP = new char[rowsP][colmP];

        //Fill P Grid
        for (int i = 0; i < rowsP; i++) {
            char[] pSplit = p[i].toCharArray();
            for (int k = 0; k < colmP; k++) {
                gridP[i][k] = pSplit[k];
            }
        }
        System.out.println("Grid p is " + Arrays.deepToString(gridP));

         int colmG = g[0].length();
         int rowsG = g.length;
         char[][] gridG = new char[rowsG][colmG];

        //Fill G Grid
        for (int i = 0; i < rowsG; i++) {
            char[] gSplit = g[i].toCharArray();
            for (int k = 0; k < colmG; k++) {
                gridG[i][k] = gSplit[k];
            }
        }
        System.out.println("Grid g is " + Arrays.deepToString(gridG));

        for (int i = 0; i < colmG; i++) {
            for (int k = 0; k < rowsG; k++) {
                //If there is a pattern match with the first
                if (gridG[i][k] == gridP[0][0]) {

                }
            }
        }

        return "NO";

    }

    //Checks if the pattern matches to the section in grid
    public static boolean isPattern(int[][] Grid, int i, int j, int[][] Pattern)
    {
        if(i > Grid.length-Pattern.length || j > Grid[0].length-Pattern[0].length){return false;} //Returns false if the pattern
        //can't even fit
        int rowG = i;
        int colG = j;

        for(int rowP = 0; rowP < Pattern.length; rowP++)
        {
            for(int colP = 0; colP < Pattern[0].length; colP++)
            {
                if(Grid[rowG][colG] != Pattern[rowP][colP]){return false;}
                colG++;
            }
            colG = j;
            rowG++;
        }
        return true; //Pattern matched in every case
    }

//    static private boolean checkGrid(int g1, int g2, char gridG[][], char gridP[][]) {
//
//        char gridPCopy[][] = Arrays.copyOf(gridP, gridP.length);
//
//        try {
//            for (int i = g1; i < g1 + gridP.length-1 ; i++) {
//                for (int j = g2; j < (g2 + (gridP[0].length-1)); j++) {
//                    gridPCopy[i][j] = gridG[i][j];
//                }
//                System.out.println("");
//            }
//
//            System.out.println("Grid p is " + Arrays.deepToString(gridP));
//            System.out.println("Grid p copy is " + Arrays.deepToString(gridPCopy));
//
//            if (gridP.equals(gridPCopy));
//        } catch (IndexOutOfBoundsException ex) {
//            return false;
//        }
//
//        return false;
//
//    }

}
