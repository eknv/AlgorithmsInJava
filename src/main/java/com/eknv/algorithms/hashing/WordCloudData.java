package com.eknv.algorithms.hashing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You want to build a word cloud, an infographic
 * where the size of a word corresponds to how often it appears in the body of text.
 * <p>
 * To do this, you'll need data. Write code that takes a long string
 * and builds its word cloud data in a hash map,
 * where the keys are words and the values are the number of times the words occurred.
 * <p>
 * Think about capitalized words. For example, look at these sentences:
 * <p>
 * "After beating the eggs, Dana read the next step:"
 * "Add milk and eggs, then add flour and sugar."
 * <p>
 * What do we want to do with "After", "Dana", and "add"?
 * In this example, your final hash map should include one "Add" or "add" with a value of 2.
 * Make reasonable (not necessarily perfect) decisions about cases like "After" and "Dana".
 * <p>
 * Assume the input will only contain words and standard punctuation.
 * <p>
 * You could make a reasonable argument to use regex in your solution.
 * We won't, mainly because performance is difficult to measure and can get pretty bad.
 */
public class WordCloudData {

    private WordCloudData() {
    }

    private static Logger logger = LoggerFactory.getLogger(WordCloudData.class);

    public static Map<String, Integer> getWordsToCounts(String inputString) {

        Map<String, Integer> wordCount = new HashMap<>();

        String[] words = inputString.split("[^a-zA-Z-']+");
        for (String word : words) {
            wordCount.compute(word.toLowerCase(), (str, count) -> count == null ? 1 : ++count);
        }

        if (logger.isDebugEnabled()) {
            logger.debug(Arrays.toString(words));
            logger.debug(wordCount.toString());
        }

        return wordCount;
    }

}
