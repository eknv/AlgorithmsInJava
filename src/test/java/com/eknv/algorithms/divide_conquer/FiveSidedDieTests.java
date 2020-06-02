package com.eknv.algorithms.divide_conquer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class FiveSidedDieTests {

    private Logger logger = LoggerFactory.getLogger(FiveSidedDieTests.class);

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void test1(int retries) {

        Map<Integer, Integer> randomNumberOccurrences = new HashMap<>();

        for (int i = 0; i < retries; i++) {
            randomNumberOccurrences.compute(FiveSidedDie.execute(), (k, v) -> v == null ? 1 : ++v);
        }

        int exactDistributionOccurrence = retries / 5;
        /**
         * allowed deviation = 20%
         */
        double allowedDeviation = 0.2;

        /**
         * testing that the generated numbers are well distributed
         */
        logger.debug(randomNumberOccurrences.toString());

        randomNumberOccurrences.values().forEach(
                occurrence -> assertTrue(Math.abs(occurrence - exactDistributionOccurrence) < (exactDistributionOccurrence * allowedDeviation))
        );

    }


    private static IntStream dataProvider() {
        Random random = new SecureRandom();
        return IntStream.range(0, 10).map(val -> 1000 + random.nextInt(10_000));
    }

}
