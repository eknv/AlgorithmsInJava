package com.eknv.algorithms.divide_conquer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ClosestPairOfPointsTests {

    @Test
    public void test1() {

        ClosestPairOfPoints.Point[] points = new ClosestPairOfPoints.Point[]{
                new ClosestPairOfPoints.Point(-2, 3),
                new ClosestPairOfPoints.Point(4, 2),
                new ClosestPairOfPoints.Point(0, 0),
                new ClosestPairOfPoints.Point(-2, -2),
                new ClosestPairOfPoints.Point(3, -1)
        };

        assertEquals(2.8284271247461903D, ClosestPairOfPoints.calculate(points));
    }

    @Test
    public void test2() {
        ClosestPairOfPoints.Point[] points = new ClosestPairOfPoints.Point[]{
                new ClosestPairOfPoints.Point(2, 3),
                new ClosestPairOfPoints.Point(12, 30),
                new ClosestPairOfPoints.Point(40, 50),
                new ClosestPairOfPoints.Point(5, 1),
                new ClosestPairOfPoints.Point(12, 10),
                new ClosestPairOfPoints.Point(3, 4)
        };
        assertEquals(1.4142135623730951D, ClosestPairOfPoints.calculate(points));
    }

}
