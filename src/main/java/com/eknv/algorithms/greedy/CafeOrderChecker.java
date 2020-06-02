package com.eknv.algorithms.greedy;

import org.springframework.util.Assert;

/**
 * My cake shop is so popular, I'm adding some tables and hiring wait staff so folks can have a cute sit-down cake-eating experience.
 * I have two registers: one for take-out orders, and the other for the other folks eating inside the cafe.
 * All the customer orders get combined into one list for the kitchen, where they should be handled first-come, first-served.
 * Recently, some customers have been complaining that people who placed orders after them are getting their food first.
 * Yikes—that's not good for business!
 * <p>
 * To investigate their claims, one afternoon I sat behind the registers with my laptop and recorded:
 * The take-out orders as they were entered into the system and given to the kitchen. (takeOutOrders)
 * The dine-in orders as they were entered into the system and given to the kitchen. (dineInOrders)
 * Each customer order (from either register) as it was finished by the kitchen. (servedOrders)
 * <p>
 * Given all three arrays, write a method to check that my service is first-come, first-served.
 * All food should come out in the same order customers requested it.
 * <p>
 * We'll represent each customer order as a unique integer.
 * As an example,
 * Take Out Orders: [1, 3, 5]
 * Dine In Orders: [2, 4, 6]
 * Served Orders: [1, 2, 4, 6, 5, 3]
 * would not be first-come, first-served, since order 3 was requested before order 5 but order 5 was served first.
 * <p>
 * But,
 * Take Out Orders: [17, 8, 24]
 * Dine In Orders: [12, 19, 2]
 * Served Orders: [17, 8, 12, 19, 24, 2]
 * would be first-come, first-served.
 * <p>
 * Note: Order numbers are arbitrary. They do not have to be in increasing order.
 */
public class CafeOrderChecker {

    private CafeOrderChecker() {
    }

    public static boolean isFirstComeFirstServed(int[] takeOutOrders, int[] dineInOrders, int[] servedOrders) {

        Assert.notNull(takeOutOrders, "takeOutOrders");
        Assert.notNull(dineInOrders, "dineInOrders");
        Assert.notNull(servedOrders, "servedOrders");

        /**
         * sum of the size of the dine-in and take-out orders should be the same as the served-orders
         */
        if (takeOutOrders.length + dineInOrders.length != servedOrders.length) {
            return false;
        }

        /**
         * if all orders are empty, it is ok
         */
        if (takeOutOrders.length == 0 && dineInOrders.length == 0 && servedOrders.length == 0) {
            return true;
        }

        /**
         * if the served orders is empty, something is wrong
         */
        if (servedOrders.length == 0) {
            return false;
        }


        /**
         * check if we're serving orders first-come, first-served
         */
        int takeOutIndex = 0;
        int dineInIndex = 0;
        int servedOrdersIndex = 0;


        while (servedOrdersIndex != servedOrders.length - 1) {
            if (takeOutOrders.length > 0 && takeOutOrders[takeOutIndex] == servedOrders[servedOrdersIndex]) {
                takeOutIndex++;
                servedOrdersIndex++;
            } else if (dineInOrders.length > 0 && dineInOrders[dineInIndex] == servedOrders[servedOrdersIndex]) {
                dineInIndex++;
                servedOrdersIndex++;
            } else {
                break;
            }
        }

        return servedOrdersIndex == servedOrders.length - 1;
    }

}
