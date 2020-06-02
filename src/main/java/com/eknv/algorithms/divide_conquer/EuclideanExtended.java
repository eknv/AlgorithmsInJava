package com.eknv.algorithms.divide_conquer;

/**
 * Extended Euclidean algorithm also finds integer coefficients x and y such that:
 * <p>
 * ax + by = gcd(a, b)
 */
public class EuclideanExtended {

    private EuclideanExtended() {
    }

    public static class GCD {
        private int x;
        private int y;
        private int value;

        public GCD(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return String.format("GCD: %d, X: %d, Y: %d", value, x, y);
        }
    }


    /**
     * extended Euclidean Algorithm
     */
    /**
     * Function to solve
     **/

    public static GCD calculate(int a, int b) {

        int x = 0;
        int y = 1;
        int lastx = 1;
        int lasty = 0;

        while (b != 0) {

            int quotient = a / b;
            int remainder = a % b;

            a = b;
            b = remainder;

            int temp = x;
            x = lastx - quotient * x;
            lastx = temp;

            temp = y;
            y = lasty - quotient * y;
            lasty = temp;

        }

        return new GCD(a, lastx, lasty);
    }

}

