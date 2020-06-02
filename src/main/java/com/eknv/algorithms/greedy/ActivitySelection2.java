package com.eknv.algorithms.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ActivitySelection2 {

    private ActivitySelection2() {
    }

    public static List<String> calculate(List<Activity> selectionList) {

        List<String> taskNames = new ArrayList<>();

        if (selectionList.isEmpty()) {
            return taskNames;
        }

        Collections.sort(selectionList, Comparator.comparing(Activity::getEnd));

        // The first activity always gets selected
        int currentTaskIndex = 0;

        taskNames.add(selectionList.get(currentTaskIndex).getName());

        // Consider rest of the activities
        for (int i = 1; i < selectionList.size(); i++) {
            if (selectionList.get(i).getStart() >= selectionList.get(currentTaskIndex).getEnd()) {
                taskNames.add(selectionList.get(i).getName());
                currentTaskIndex = i;
            }
        }

        return taskNames;
    }

    public static class Activity {
        private int start;
        private int end;
        private String name;

        public Activity(String name, int start, int end) {
            this.name = name;
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return getName();
        }
    }

}
