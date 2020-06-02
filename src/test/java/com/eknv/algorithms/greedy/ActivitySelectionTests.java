package com.eknv.algorithms.greedy;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActivitySelectionTests {

    @Test
    public void test1() {
        int[] startTimes = {1, 3, 0, 5, 8, 5};
        int[] endTimes = {2, 4, 6, 7, 9, 9};
        assertEquals("[0, 1, 3, 4]", ActivitySelection.calculate(startTimes, endTimes).toString());
    }

    @Test
    public void test2() {

        List<ActivitySelection2.Activity> selectionList = Arrays.asList(
                new ActivitySelection2.Activity("Task 1", 1, 2),
                new ActivitySelection2.Activity("Task 4", 5, 7),
                new ActivitySelection2.Activity("Task 5", 8, 9),
                new ActivitySelection2.Activity("Task 2", 3, 4),
                new ActivitySelection2.Activity("Task 3", 0, 6),
                new ActivitySelection2.Activity("Task 6", 5, 9)
        );

        assertEquals("[Task 1, Task 2, Task 4, Task 5]", ActivitySelection2.calculate(selectionList).toString());
    }

}