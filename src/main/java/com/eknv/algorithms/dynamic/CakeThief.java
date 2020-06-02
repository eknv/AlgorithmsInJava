package com.eknv.algorithms.dynamic;

/**
 * You are a renowned thief who has recently switched from stealing precious metals
 * to stealing cakes because of the insane profit margins.
 * You end up hitting the jackpot, breaking into the world's largest
 * privately owned stock of cakes—the vault of the Queen of England.
 * <p>
 * While Queen Elizabeth has a limited number of types of cake, she has an unlimited supply of each type.
 * <p>
 * Each type of cake has a weight and a value, stored in objects of a CakeType class:
 * <p>
 * public class CakeType {
 * <p>
 * final int weight;
 * final int value;
 * <p>
 * public CakeType(int weight, int value) {
 * this.weight = weight;
 * this.value  = value;
 * }
 * }
 * <p>
 * Java
 * <p>
 * For example:
 * <p>
 * // weighs 7 kilograms and has a value of 160 shillings
 * new CakeType(7, 160);
 * <p>
 * // weighs 3 kilograms and has a value of 90 shillings
 * new CakeType(3, 90);
 * <p>
 * You brought a duffel bag that can hold limited weight, and you want to make off with the most valuable haul possible.
 * <p>
 * Write a method maxDuffelBagValue() that takes an array of cake type objects and a weight capacity,
 * and returns the maximum monetary value the duffel bag can hold.
 * <p>
 * For example:
 * <p>
 * CakeType[] cakeTypes = new CakeType[] {
 * new CakeType(7, 160),
 * new CakeType(3, 90),
 * new CakeType(2, 15),
 * };
 * <p>
 * int capacity = 20;
 * <p>
 * maxDuffelBagValue(cakeTypes, capacity);
 * // returns 555 (6 of the middle type of cake and 1 of the last type of cake)
 * <p>
 * Weights and values may be any non-negative integer. Yes, it's weird to think about cakes that weigh nothing
 * or duffel bags that can't hold anything.
 * But we're not just super mastermind criminals—we're also meticulous about keeping our algorithms flexible and comprehensive.
 */
public class CakeThief {


    private CakeThief() {
    }

    public static class CakeType {

        private int weight;
        private int value;

        public CakeType(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

    public static long maxDuffelBagValue(CakeType[] cakeTypes, int weightCapacity) {


        if (cakeTypes == null || cakeTypes.length == 0) {
            throw new IllegalArgumentException("No Cake types are provided");
        }

        if (weightCapacity < 0) {
            throw new IllegalArgumentException("Weight capacity cannot be minus");
        }

        for (CakeType cakeType : cakeTypes) {
            if (cakeType.value > 0 && cakeType.weight <= 0) {
                throw new IllegalArgumentException("The weight of the cake types should be a positive value");
            }
        }


        long[] maxValues = new long[weightCapacity + 1];
        maxValues[0] = 0;

        for (int cap = 0; cap <= weightCapacity; cap++) {

            for (CakeType cakeType : cakeTypes) {
                if (cakeType.weight <= cap) {
                    maxValues[cap] = Math.max(
                            maxValues[cap],
                            maxValues[cap - cakeType.weight] + cakeType.getValue()
                    );
                }
            }

        }


        return maxValues[weightCapacity];
    }

}