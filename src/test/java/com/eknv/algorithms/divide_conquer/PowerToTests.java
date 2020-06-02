package com.eknv.algorithms.divide_conquer;

import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PowerToTests {

    @Test
    public void testIterative() {

        Random random = new SecureRandom();

        int count = 0;
        while (count < 100) {
            int x = -20 + random.nextInt(40);
            if (x == 0) {
                continue;
            }
            int y = -20 + random.nextInt(40);

            assertEquals(Math.pow(x, y), PowerTo.execute(x, y).doubleValue());
            count++;
        }
    }


}
