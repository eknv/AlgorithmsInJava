package com.eknv.algorithms.sort_search;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given a sequence of words, print all anagrams together | Set 1
 * Given an array of words, print all anagrams together.
 * <p>
 * For example, if the given array is {“cat”, “dog”, “tac”, “god”, “act”},
 * then output may be “cat tac act dog god”.
 * <p>
 * Given N number of words each having M characters
 * Time complexity: O(NMLogM + MNLogN)
 * - MLOG(M) for sorting a word
 * - N words, so NMLOG(M)
 * - NLOGN (sorting the words as well)
 * Space complexity: O()
 */
public class AnagramsSorter {

    private AnagramsSorter() {
    }

    public static List<String> execute(String[] str) {

        Word[] words = new Word[str.length];
        for (int i = 0; i < str.length; i++) {
            char[] wordChars = str[i].toCharArray();
            Arrays.sort(wordChars);
            words[i] = new Word(new String(wordChars), str[i], i);
        }

        Arrays.sort(words);

        return Stream.of(words).map(Word::getOriginalStr).collect(Collectors.toList());
    }

    /**
     * Utility Class
     */
    private static class Word implements Comparable<Word> {
        private String str;
        private String originalStr;
        private int index;

        public Word(String str, String originalStr, int index) {
            this.str = str;
            this.originalStr = originalStr;
            this.index = index;
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getOriginalStr() {
            return originalStr;
        }

        public void setOriginalStr(String originalStr) {
            this.originalStr = originalStr;
        }

        @Override
        public int compareTo(Word word) {
            return new CompareToBuilder()
                    .append(this.str, word.getStr())
                    .append(this.originalStr, word.getOriginalStr())
                    .toComparison();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(this.str).append(this.originalStr).toHashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Word)) {
                return false;
            }
            return new EqualsBuilder()
                    .append(this.str, ((Word) obj).getStr())
                    .append(this.originalStr, ((Word) obj).getOriginalStr())
                    .isEquals();
        }
    }

}

