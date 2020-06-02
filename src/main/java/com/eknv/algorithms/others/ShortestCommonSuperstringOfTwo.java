package com.eknv.algorithms.others;

/**
 * the shortest string that contains the given two strings
 */

public class ShortestCommonSuperstringOfTwo {

    private int getNrOfCommon(String text1, String text2) {

        int index1 = text1.length();
        int index2 = 0;
        int common = 0;

        while (index1 > 0 && index2 < text2.length()) {
            if (text1.substring(index1 - 1).equals(text2.substring(0, index2 + 1))) {
                common = index2 + 1;
            }
            index1--;
            index2++;
        }

        return common;
    }

    public String calculate(String first, String second) {


        int common12 = getNrOfCommon(first, second);
        int common21 = getNrOfCommon(second, first);

        if (common12 >= common21) {
            return first + second.substring(common12);
        } else {
            return second + first.substring(common21);
        }
    }

}
