package com.crystal;

public class MagicalBinaryString {

    static int largestLexicographically = 0;


    public static void main (String [] args) {

        String binString = "11011000";
        System.out.println(largestMagical(binString));

    }

    //Test 1
/*
* Complete the function below.
*/
    public static String largestMagical(String binString) {
        //Magical String has equal amount of 1's and 0's
        //For every prefix of the binary string, the number of 1's should not be less than 0's

        String largestMagical = "1";

        for (int i = 0 ; i < binString.length()-1; i++) {

            for (int j = i+1; j < binString.length(); j++) {


                String prefix = binString.substring(i, j);
                //If substring is magical String
                if (isMagical(prefix)) {

                    String secondMagicalSubString = findMagicalSubString(binString.substring(j+ 1, binString.length()));

                    if (secondMagicalSubString.length() > 1) {
                        String swappedString = swap(binString, i, j, j + 1, j + 1 + secondMagicalSubString.length());
                        if (Integer.parseInt(swappedString, 2) > largestLexicographically) {
                            largestMagical = swappedString;
                        }
                    }
                }

            }

        }

        return largestMagical;
    }

    static String findMagicalSubString(String binString) {

        String magicalSubString = "";

        for (int i = 0 ; i < binString.length()-1; i++) {

            for (int j = i+1; j < binString.length(); j++) {


                String subString = binString.substring(i, j);
                //If substring is magical String
                if (isMagical(subString)) {

                    magicalSubString = subString;

                }

            }

        }

        return magicalSubString;

    }


    static String swap (String s, int subStringIndex1, int subStringIndex2, int subString2Index1, int subString2Index2) {

        String swappedString = "";
        String temp = s.substring(subStringIndex1, subStringIndex2);
        swappedString = s.replace(s.substring(subStringIndex1, subStringIndex2), s.substring(subString2Index1, subString2Index2));
        swappedString = swappedString.replace(s.substring(subString2Index1, subString2Index2), temp);

        return swappedString;
    }

    static int getLargestLexicographically (String binString) {
        return Integer.parseInt(binString, 2);
    }

    static boolean isMagical (String binString) {
        if (equalOnesZeros(binString) && allPrefixesHasGreaterOnes(binString))
            return true;
        else
            return false;
    }

    static boolean equalOnesZeros (String binString) {

        long numOfZeros = 0, numOfOnes = 0;

        numOfZeros = binString.chars().filter(num -> num == '0').count();
        numOfOnes = binString.chars().filter(num -> num == '1').count();

        if (numOfZeros == numOfOnes)
            return true;
        else
            return false;

    }

    static boolean allPrefixesHasGreaterOnes(String binString) {
        for (int i = 0; i < binString.length()-1; i++) {
            String prefix = binString.substring(0, i);
            if (prefix.chars().filter(num -> num == '0').count() >
                    prefix.chars().filter(num -> num == '1').count())
                return false;
        }

        return true;
    }

}
