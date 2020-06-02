package com.eknv.algorithms.sort_search;// Java code tp print all anagrams together

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given N number of words each having M characters
 * Time complexity: O(NM)
 * Space complexity: O(N+M)
 */
public class AnagramsSorter2 {

    private AnagramsSorter2() {
    }

    public static List<List<String>> execute(String[] list) {

        Map<Map<Character, Integer>, List<String>> mainMap = new HashMap<>();

        for (String str : list) {

            Map<Character, Integer> tempMap = new HashMap<>();

            /**
             * Counting the frequency of the characters present in the string
             */
            for (int i = 0; i < str.length(); i++) {
                if (tempMap.containsKey(str.charAt(i))) {
                    int x = tempMap.get(str.charAt(i));
                    tempMap.put(str.charAt(i), ++x);
                } else {
                    tempMap.put(str.charAt(i), 1);
                }
            }

            /**
             * if the same amount of the characters
             * are already present in the main map,
             * then we can add this string to that list,
             * otherwise create a new list for it
             */
            if (mainMap.containsKey(tempMap)) {
                mainMap.get(tempMap).add(str);
            } else {
                ArrayList<String> tempList = new ArrayList<>();
                tempList.add(str);
                mainMap.put(tempMap, tempList);
            }
        }

        /**
         * storing the results in a list
         */
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Map<Character, Integer>, List<String>> mapToListEntry : mainMap.entrySet()) {
            result.add(mapToListEntry.getValue());
        }

        return result;
    }

}

