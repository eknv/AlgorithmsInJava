package com.eknv.algorithms.hashing;

import java.util.*;

public class AnagramsFinder {

    private AnagramsFinder() {
    }

    public static List<List<String>> execute(String[] str) {

        Map<String, List<String>> wordsMap = new HashMap<>();

        for (int i = 0; i < str.length; i++) {
            String word = str[i];
            char[] wordChars = word.toCharArray();
            Arrays.sort(wordChars);
            String sortedWord = new String(wordChars);

            List<String> anagramList = wordsMap.computeIfAbsent(sortedWord, k -> new ArrayList<>());
            anagramList.add(word);
        }

        List<List<String>> anagramList = new ArrayList<>();
        for (Map.Entry<String, List<String>> anagrams : wordsMap.entrySet()) {
            if (anagrams.getValue().size() > 1) {
                anagramList.add(anagrams.getValue());
            }
        }

        return anagramList;
    }

} 
