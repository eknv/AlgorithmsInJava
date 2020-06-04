package com.eknv.algorithms.dynamic;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * <p>
 * Write a program that takes a String and the number of characters that can be ignored
 * and return the minimum possible size of the string
 * <p>
 * Input: AAAAAAAAAAxedAAAAAAAAAABBtxzuBBBBB, 3
 * Output: 14
 * <p>
 * In this example, the characters xed in the middle can be ignored
 * the string then looks like AAAAAAAAAAAAAAAAAAAABBtxzuBBBBB
 * which then can be compressed to 20ABBtxzuBBBBB
 * the result is then the size of the final string which is 14
 * Note: we assume that a character cannot be repeated more than 10_000 times in a row
 */
public class MinStringCompressionSize {


    private static Logger logger = LoggerFactory.getLogger(MinStringCompressionSize.class);

    private MinStringCompressionSize() {
    }

    /**
     * the problem is solved using dynamic programming techniques
     * we iterate over the characters in the string and keep track of the following information:
     * - gains at each position
     * - min-size of the compressed string at each position
     * - max gain so far
     * <p>
     * in case the gain at a position is higher than the max-gain so far,
     * then we cancel the previous gain and take the new gain
     * <p>
     * otherwise, we just compress as much as possible without any merging, even if merging is possible
     */
    public static int calculate(String str, int maxCharsToIgnore) {

        int[] compressedSizes = new int[str.length() + 1];
        int[] gains = new int[str.length() + 1];

        compressedSizes[0] = 0;
        gains[0] = 0;
        int maxGainByMerging = 0;

        for (int i = 1; i <= str.length(); i++) {

            char c = str.charAt(i - 1);

            logger.debug("------------------ index: {}, char: {} ------------------", i, c);

            Result result = process(str, c, i - 1, maxCharsToIgnore);

            logger.debug("{}", result);

            gains[i] = result.retrieveAdditionalGainByMerging();

            logger.debug("currentGain: {} - maxGain: {}", result.retrieveAdditionalGainByMerging(), maxGainByMerging);

            /**
             * nothing to compress
             */
            if (result.getSimilarChars() == 1) {
                compressedSizes[i] = compressedSizes[i - 1] + 1;
            }
            /**
             * in case the gain at this position is higher than the max-gain by merging so far
             * then we cancel the previous gain and take the new gain
             */
            else if (result.retrieveAdditionalGainByMerging() > maxGainByMerging) {

                logger.debug("Prev-Index: {} - Prev-Val: {}, compressSize: {}, Prev-Gain: {}",
                        i - result.numberOfProcessedChars(),
                        compressedSizes[i - result.numberOfProcessedChars()],
                        result.compressSize(true),
                        gains[i - result.numberOfProcessedChars()]
                );

                compressedSizes[i] = compressedSizes[i - result.numberOfProcessedChars()]
                        + result.compressSize(true) // compress after merging
                        + gains[i - result.numberOfProcessedChars()]; // gains we had at position where there new merging starts

                maxGainByMerging = result.retrieveAdditionalGainByMerging();

            }
            /**
             * otherwise just compress as much as possible without any merging
             * even if merging is possible
             */
            else {

                logger.debug("Index: {}, Value: {}, compressSize: {}",
                        i - result.getSimilarCharsWithoutMerging(),
                        compressedSizes[i - result.getSimilarCharsWithoutMerging()],
                        result.compressSize(false));

                compressedSizes[i] = compressedSizes[i - result.getSimilarCharsWithoutMerging()] + result.compressSize(false);
            }


            logger.debug("compressedSizes[i]: {}", compressedSizes[i]);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("{}", Arrays.toString(gains));
            logger.debug("{}", Arrays.toString(compressedSizes));
        }

        return compressedSizes[str.length()];
    }

    private static Result process(String str, char c, int position, int maxCharsToIgnore) {

        int similarChars = 0;
        int similarCharsWithoutIgnoring = 0;
        int ignoredChars = 0;

        for (int i = position; i >= 0; i--) {
            if (str.charAt(i) == c) {
                similarChars++;
                if (ignoredChars == 0) {
                    similarCharsWithoutIgnoring++;
                }
            } else {
                ignoredChars++;
                if (ignoredChars > maxCharsToIgnore) {
                    ignoredChars = maxCharsToIgnore;
                    break;
                }
            }
        }

        return new Result(similarChars, ignoredChars, similarCharsWithoutIgnoring);
    }


    private static class Result {
        private int similarChars;
        private int ignoredChars;
        private int similarCharsWithoutMerging;

        public Result(int similarChars, int ignoredChars, int similarCharsWithoutMerging) {
            this.similarChars = similarChars;
            this.ignoredChars = ignoredChars;
            this.similarCharsWithoutMerging = similarCharsWithoutMerging;
        }

        public int getSimilarChars() {
            return similarChars;
        }

        public int getIgnoredChars() {
            return ignoredChars;
        }

        public int getSimilarCharsWithoutMerging() {
            return similarCharsWithoutMerging;
        }


        public int numberOfProcessedChars() {
            return similarChars + ignoredChars;
        }

        /**
         * calculate the compressed size of the string if no merging were done
         */
        public int compressSizeWithoutMerging() {
            return compressSize(similarCharsWithoutMerging) // immediate similar chars behind the current position
                    + compressSize(similarChars - similarCharsWithoutMerging) // additional chars
                    + ignoredChars;
        }

        public int retrieveAdditionalGainByMerging() {
            /**
             * if no character is ignored, then there has been no gain because of merging
             */
            if (ignoredChars == 0) {
                return 0;
            } else {
                return compressSizeWithoutMerging() - compressSize(similarChars);
            }
        }

        /**
         * this method calculates the size of a compressed string with the very same chars with the given length
         */
        public int compressSize(boolean withMerging) {
            int value = withMerging ? similarChars : similarCharsWithoutMerging;
            return compressSize(value);
        }

        public int compressSize(int value) {
            if (value <= 2) {
                return value;
            } else if (value < 10) {
                return 2;
            } else if (value < 100) {
                return 3;
            } else if (value < 1000) {
                return 4;
            } else if (value < 10000) {
                return 5;
            }

            throw new IllegalArgumentException("Lengths bigger than 10000 are not supported");
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.NO_CLASS_NAME_STYLE)
                    .append("similar ", similarChars)
                    .append("ignored ", ignoredChars)
                    .append("sum ", numberOfProcessedChars())
                    .toString();
        }
    }

}
