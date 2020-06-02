package com.eknv.algorithms.greedy;

import org.springframework.util.Assert;

/**
 * Writing programming interview questions hasn't made me rich yet ...
 * so I might give up and start trading Apple stocks all day instead.
 * <p>
 * First, I wanna know how much money I could have made yesterday if I'd been trading Apple stocks all day.
 * <p>
 * So I grabbed Apple's stock prices from yesterday and put them in an array called stockPrices, where:
 * <p>
 * The indices are the time (in minutes) past trade opening time, which was 9:30am local time.
 * The values are the price (in US dollars) of one share of Apple stock at that time.
 * <p>
 * So if the stock cost $500 at 10:30am, that means stockPrices[60] = 500.
 * <p>
 * Write an efficient method that takes stockPrices and returns the best profit
 * I could have made from one purchase and one sale of one share of Apple stock yesterday.
 * <p>
 * For example:
 * <p>
 * int[] stockPrices = new int[] {10, 7, 5, 8, 11, 9};
 * <p>
 * getMaxProfit(stockPrices);
 * // returns 6 (buying for $5 and selling for $11)
 * <p>
 * No "shorting"—you need to buy before you can sell.
 * Also, you can't buy and sell in the same time step—at least 1 minute has to pass.
 */
public class AppleStock {

    private AppleStock() {
    }

    public static int calculate(int[] prices) {

        Assert.notNull(prices, "prices");
        Assert.isTrue(prices.length > 1, "prices.length > 0");

        int minprice = prices[0];
        int maxprofit = prices[1] - prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if ((prices[i] - minprice) > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }

        return maxprofit;
    }

}
