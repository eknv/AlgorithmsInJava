package com.eknv.algorithms.greedy;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Fractional Knapsack Problem
 * Calculate the max value for the given capacity
 */
public class FractionalKnapsack {


    private FractionalKnapsack() {
    }


    public static double calculate(double[] wt, double[] val, double capacity) {

        List<Item> items = new ArrayList<>();

        for (int i = 0; i < wt.length; i++) {
            items.add(new Item(wt[i], val[i]));
        }

        /**
         * sort items by cost
         */
        Collections.sort(items, (o1, o2) -> o2.cost.compareTo(o1.cost));

        double totalValue = 0d;

        for (Item item : items) {

            /**
             * item can be picked whole
             */
            if (capacity > item.getWeight()) {
                capacity = capacity - item.getWeight();
                totalValue += item.getValue();
            }
            /**
             * item cannot be picked whole
             */
            else {
                double weightFraction = capacity / item.getWeight();
                totalValue += weightFraction * item.getValue();
                break;
            }

        }

        return totalValue;
    }

    private static class Item {
        private Double cost;
        private double weight;
        private double value;

        // item value function
        public Item(double weight, double value) {
            Assert.notNull(weight, "weight");
            this.weight = weight;
            this.value = value;
            this.cost = this.value / this.weight;
        }

        public Double getCost() {
            return cost;
        }

        public void setCost(Double cost) {
            this.cost = cost;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }
    }
} 
