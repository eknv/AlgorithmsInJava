package com.eknv.algorithms.greedy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * Task Description
 * <p>
 * A vending machine has the following denominations: 1c, 5c, 10c, 25c, 50c, and $1. Y
 * our task is to write a program that will be used in a vending machine to return change.
 * Assume that the vending machine will always want to return the least number of coins or notes.
 * Devise a function getChange(M, P) where M is how much money was inserted into the machine and P the price of the item selected,
 * that returns an array of integers representing the number of each denomination to return.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * getChange(5, 0.99) // should return [1,0,0,0,0,4]
 */
public class ChangeMoney {


    private static Logger logger = LoggerFactory.getLogger(ChangeMoney.class);

    private static double[] coins = new double[]{1, 0.5, 0.25, 0.1, 0.05, 0.01};


    private ChangeMoney() {
    }

    public static int[] calculate(double money, double price) {

        int[] takenCoins = new int[coins.length];

        BigDecimal returnValue = BigDecimal.valueOf(money);

        returnValue = returnValue.subtract(BigDecimal.valueOf(price));


        for (int i = 0; i < coins.length; i++) {
            logger.debug("{}", returnValue);
            while (returnValue.compareTo(BigDecimal.valueOf(coins[i])) >= 0) {
                takenCoins[i]++;
                returnValue = returnValue.subtract(BigDecimal.valueOf(coins[i]));
            }
        }

        return takenCoins;
    }

}
