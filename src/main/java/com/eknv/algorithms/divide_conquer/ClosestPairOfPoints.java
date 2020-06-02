package com.eknv.algorithms.divide_conquer;


import java.util.*;

/**
 * Find the smallest distance from a given set of points
 */
public class ClosestPairOfPoints {

    private ClosestPairOfPoints() {
    }

    /**
     * The main function that finds the smallest distance
     * This method mainly uses calculateRecursively()
     */
    public static double calculate(Point[] points) {

        Arrays.sort(points, Comparator.comparingInt(Point::getX));

        return calculateRecursively(points, 0, points.length - 1);
    }


    /**
     * A utility function to find the distance between two points
     */
    private static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
    }


    /**
     * A Brute Force method to return the smallest distance between two points in P[] of size n
     */
    private static double bruteForce(Point[] points, int startIndex, int endIndex) {
        double min = Double.MAX_VALUE;
        for (int i = startIndex; i <= endIndex; i++) {
            for (int j = i + 1; j <= endIndex; j++) {
                double dist = distance(points[i], points[j]);
                if (dist < min) {
                    min = dist;
                }
            }
        }
        return min;
    }

    /**
     * A utility function to find the distance beween the closest points of
     * strip of given size. All points in strip[] are sorted according to
     * y coordinate. They all have an upper bound on minimum distance as d.
     * Note that this method seems to be a O(n^2) method, but it's a O(n)
     * method as the inner loop runs at most 6 times
     */
    private static double closestInStrip(List<Point> strip, double distance) {

        if (strip.size() == 1) {
            return distance;
        }

        // Initialize the minimum distance
        double min = distance;

        Collections.sort(strip, Comparator.comparingInt(Point::getY));

        /**
         * pick all points one by one and try the next points till the difference
         * between y coordinates is smaller than d.
         * This is a proven fact that this loop runs at most 6 times
         */
        for (int i = 0; i < strip.size() - 1; i++) {
            for (int j = i + 1; j < strip.size() && (strip.get(j).y - strip.get(i).y) < min; j++) {
                if (distance(strip.get(i), strip.get(j)) < min) {
                    min = distance(strip.get(i), strip.get(j));
                }
            }
        }

        return min;
    }


    /**
     * A recursive function to find the smallest distance.
     * The array P contains all points sorted according to x coordinate
     */
    private static double calculateRecursively(Point[] points, int startIndex, int endIndex) {

        /**
         * bruteforce for less than or equal to 3 points
         */
        if ((endIndex - startIndex) <= 3) {
            return bruteForce(points, startIndex, endIndex);
        }

        // Find the middle point
        int mid = (startIndex + endIndex) / 2;
        Point midPoint = points[mid];

        /**
         * Consider the vertical line passing through the middle point calculate
         * the smallest distance dl on left of middle point and dr on right side
         */
        double dl = calculateRecursively(points, startIndex, mid);
        double dr = calculateRecursively(points, mid + 1, endIndex);

        // Find the smaller of two distances
        double minDistance = Math.min(dl, dr);

        /**
         * Build an array strip[] that contains
         * points close (closer than d)
         * to the line passing through the middle point
         */
        List<Point> strip = new ArrayList<>();
        for (int i = startIndex; i <= endIndex; i++) {
            if (Math.abs(points[i].x - midPoint.x) < minDistance) {
                strip.add(points[i]);
            }
        }

        /**
         * Find the closest points in strip.
         * Return the minimum of d and closest
         * distance is strip[]
         */
        return Math.min(minDistance, closestInStrip(strip, minDistance));
    }


    public static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }


}


