package com.eknv.algorithms.others;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.*;


/**
 * Given a list of points with their X and Y coordinates each having a Tag
 * The tags for each of the points is the character at the respective index in the given string S
 * <p>
 * Write a program that returns the number of points in the cycle around the root coordinate (0,0)
 * where all of the points have unique tags
 * differently put, no two points in this cycle should have the same tag
 */
public class UniquePointsInCircle {

    private static Logger logger = LoggerFactory.getLogger(UniquePointsInCircle.class);

    private UniquePointsInCircle() {
    }

    public static int calculate(String tags, int[] x, int[] y) {

        Assert.isTrue(tags != null && x != null && y != null,
                "S != null && X != null && Y != null");

        Assert.isTrue(tags.length() == x.length && tags.length() == y.length,
                "S.length() == X.length && S.length() == Y.length");

        PriorityQueue<Point> points = new PriorityQueue<>();

        Map<String, Integer> distanceCounts = new HashMap<>();

        for (int i = 0; i < x.length; i++) {
            Point nextPoint = new Point(x[i], y[i], tags.charAt(i));
            points.add(nextPoint);
            distanceCounts.compute(nextPoint.getKey(), (k, v) -> v == null ? 1 : v + 1);
        }

        List<Character> includedTags = new ArrayList<>();

        int numberOfTakenPoints = 0;

        logger.debug("{}", distanceCounts);

        while (!points.isEmpty()) {
            Point nextPoint = points.poll();
            Integer distanceCount = distanceCounts.get(nextPoint.getKey());
            if (includedTags.contains(nextPoint.getTag()) || distanceCount > 1) {
                break;
            } else {
                includedTags.add(nextPoint.getTag());
                numberOfTakenPoints++;
            }
        }

        return numberOfTakenPoints;
    }


    private static class Point implements Comparable<Point> {

        private int x;
        private int y;
        private Double rootDistance;
        private Character tag;

        public Point(int x, int y, Character tag) {
            this.x = x;
            this.y = y;
            this.rootDistance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
            this.tag = tag;
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

        public Character getTag() {
            return tag;
        }

        public void setTag(Character tag) {
            this.tag = tag;
        }

        public Double getRootDistance() {
            return rootDistance;
        }

        public void setRootDistance(Double rootDistance) {
            this.rootDistance = rootDistance;
        }

        private String getKey() {
            return new StringBuilder().append(tag).append(rootDistance).toString();
        }

        @Override
        public int compareTo(Point o) {
            return this.rootDistance.compareTo(o.rootDistance);
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(rootDistance).toHashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Point)) {
                return false;
            }
            return new EqualsBuilder().append(rootDistance, ((Point) obj).getRootDistance()).isEquals();
        }
    }

}
