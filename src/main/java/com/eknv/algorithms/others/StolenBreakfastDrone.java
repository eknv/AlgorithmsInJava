package com.eknv.algorithms.others;

/**
 * Your company delivers breakfast via autonomous quadcopter drones. And something mysterious has happened.
 * <p>
 * Each breakfast delivery is assigned a unique ID, a positive integer.
 * When one of the company's 100 drones takes off with a delivery, the delivery's ID is added to a list,
 * delivery_id_confirmations. When the drone comes back and lands, the ID is again added to the same list.
 * <p>
 * After breakfast this morning there were only 99 drones on the tarmac. One of the drones never made it back from a delivery.
 * We suspect a secret agent from Amazon placed an order and stole one of our patented drones.
 * To track them down, we need to find their delivery ID.
 * <p>
 * Given the list of IDs, which contains many duplicate integers and one unique integer, find the unique integer.
 * <p>
 * The IDs are not guaranteed to be sorted or sequential. Orders aren't always fulfilled in the order they were received,
 * and some deliveries get cancelled before takeoff.
 */
public class StolenBreakfastDrone {

    private StolenBreakfastDrone() {
    }

    /**
     * Use bit level:
     * XOR all the integers in the array. We start with a
     * variable uniqueDeliveryId set to 0. Every
     * time we XOR with a new ID, it will change the bits.
     * When we XOR with the same ID again, it will cancel
     * out the earlier change.
     * in the end: we'll be left with the ID that appeared once.
     */
    public static int findUniqueDeliveryId(int[] deliveryIds) {
        int uniqueDeliveryId = 0;

        for (int i = 0; i < deliveryIds.length; i++) {
            uniqueDeliveryId ^= deliveryIds[i];
        }

        return uniqueDeliveryId;
    }

}
