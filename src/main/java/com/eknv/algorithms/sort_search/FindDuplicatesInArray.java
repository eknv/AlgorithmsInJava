package com.eknv.algorithms.sort_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Find duplicates in the given array
 * This implementation uses a Map
 */
public class FindDuplicatesInArray {

    private FindDuplicatesInArray() {
    }

    public static List<Integer> execute(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length - 1; i++) {
            if (map.containsKey(arr[i])) {
                int count = map.get(arr[i]);
                map.put(arr[i], count + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        List<Integer> duplicates = new ArrayList<>();

        for (Entry<Integer, Integer> entry : map.entrySet()) {
            /**
             * if frequency is more than 1 print the element
             */
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }

        return duplicates;
    }


} 
