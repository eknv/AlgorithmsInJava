package com.eknv.algorithms.dynamic;

/**
 * Your quirky boss collects rare, old coins...
 * <p>
 * They found out you're a programmer and asked you to solve something they've been wondering for a long time.
 * <p>
 * Write a method that, given:
 * <p>
 * an amount of money
 * an array of coin denominations
 * <p>
 * computes the number of ways to make the amount of money with coins of the available denominations.
 * <p>
 * Example: for amount=4 (4¢) and denominations=[1,2,3] (1¢, 2¢ and 3¢),
 * your program would output 4 — the number of ways to make 4¢ with those denominations:
 * <p>
 * 1¢, 1¢, 1¢, 1¢
 * 1¢, 1¢, 2¢
 * 1¢, 3¢
 * 2¢, 2¢
 */
public class MakingChange {

    private MakingChange() {
    }

    public static int changePossibilities(int amount, int[] denominations) {

        // calculate the number of ways to make change
        int[] possibilitiesPerAmount = new int[amount + 1];
        possibilitiesPerAmount[0] = 1;

        for (int denomination : denominations) {

            for (int i = denomination; i <= amount; i++) {
                possibilitiesPerAmount[i] += possibilitiesPerAmount[i - denomination];
            }

        }

        return possibilitiesPerAmount[amount];
    }

}