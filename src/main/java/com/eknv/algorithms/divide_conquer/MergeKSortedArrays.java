package com.eknv.algorithms.divide_conquer;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.PriorityQueue;
import java.util.Queue;


public class MergeKSortedArrays {

    private MergeKSortedArrays() {
    }

    public static int[] execute(int[][] arr) {

        Queue<ArrayContainer> queue = new PriorityQueue<>();

        int totalLength = 0;

        for (int i = 0; i < arr.length; i++) {
            queue.add(new ArrayContainer(arr[i], 0));
            totalLength = totalLength + arr[i].length;
        }

        int m = 0;
        int[] result = new int[totalLength];

        while (!queue.isEmpty()) {
            ArrayContainer ac = queue.poll();
            result[m++] = ac.getArr()[ac.getIndex()];

            if (ac.getIndex() < ac.getArr().length - 1) {
                queue.add(new ArrayContainer(ac.getArr(), ac.getIndex() + 1));
            }
        }

        return result;
    }


    private static class ArrayContainer implements Comparable<ArrayContainer> {
        private int[] arr;
        private int index;

        public ArrayContainer(int[] arr, int index) {
            this.arr = arr;
            this.index = index;
        }

        public int[] getArr() {
            return arr;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public int compareTo(ArrayContainer o) {
            return this.arr[this.index] - o.arr[o.index];
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(this.arr[this.index]).toHashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof ArrayContainer)) {
                return false;
            }
            ArrayContainer other = ((ArrayContainer) obj);
            return new EqualsBuilder().append(this.getArr()[this.getIndex()],
                    other.getArr()[other.getIndex()]).isEquals();
        }
    }

}


