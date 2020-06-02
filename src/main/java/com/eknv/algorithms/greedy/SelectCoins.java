package com.eknv.algorithms.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * try to take the biggest coins as much as possible to build the given amount
 */
public class SelectCoins {

    private SelectCoins() {
    }

    public static List<Integer> selectCoins(int[] coins, int amount) {

        Arrays.sort(coins);

        List<Integer> takenCoins = new ArrayList<>();

        for (int i = coins.length - 1; i >= 0; i--) {
            while (amount - coins[i] >= 0) {
                amount -= coins[i];
                takenCoins.add(coins[i]);
            }
        }

        return takenCoins;

    }

}
