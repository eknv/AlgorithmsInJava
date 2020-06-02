package com.eknv.algorithms.dynamic;


/**
 * Given an infinite number of quarters like
 *  (25 cents), dimes (10 cents), nickels (5 cents), and pennies (1 cent)
 * Write code to calculate the number of ways to represent sum cents
 */
public class CoinChange {

    private CoinChange() {
    }

    public static int calculate(int sum, int[] availableCoins) {

        if (availableCoins == null || availableCoins.length == 0) {
            throw new IllegalArgumentException("No coins are provided");
        }

        if (sum < 1) {
            return 0;
        }

        int[] possibilities = new int[sum + 1];
        possibilities[0] = 1;

        for (int coin : availableCoins) {
            for (int s = coin; s <= sum; s++) {
                possibilities[s] += possibilities[s - coin];
            }
        }

        return possibilities[sum];
    }

}
