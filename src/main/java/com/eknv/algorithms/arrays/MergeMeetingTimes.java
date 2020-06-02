package com.eknv.algorithms.arrays;

import java.util.*;

/**
 * Your company built an in-house calendar tool called HiCal.
 * You want to add a feature to see the times in a day when everyone is available.
 * <p>
 * To do this, you’ll need to know when any team is having a meeting.
 * In HiCal, a meeting is stored as an object of a Meeting class with integer variables startTime and endTime.
 * These integers represent the number of 30-minute blocks past 9:00am.
 * <p>
 * For example:
 * <p>
 * new Meeting(2, 3);  // meeting from 10:00 – 10:30 am
 * new Meeting(6, 9);  // meeting from 12:00 – 1:30 pm
 * <p>
 * Write a method mergeRanges() that takes a list of multiple meeting time ranges and returns a list of condensed ranges.
 * <p>
 * For example, given:
 * <p>
 * [Meeting(0, 1), Meeting(3, 5), Meeting(4, 8), Meeting(10, 12), Meeting(9, 10)]
 * <p>
 * your method would return:
 * <p>
 * [Meeting(0, 1), Meeting(3, 8), Meeting(9, 12)]
 * <p>
 * Do not assume the meetings are in order. The meeting times are coming from multiple teams.
 * <p>
 * Write a solution that's efficient even when we can't put a nice upper bound on the numbers representing our time ranges.
 * Here we've simplified our times down to the number of 30-minute slots past 9:00 am.
 * But we want the method to work even for very large numbers, like Unix timestamps.
 * In any case, the spirit of the challenge is to merge meetings where startTime and endTime don't have an upper bound.
 */
public class MergeMeetingTimes {


    private MergeMeetingTimes() {
    }

    public static class Meeting {

        private int startTime;
        private int endTime;

        public Meeting(int startTime, int endTime) {
            // number of 30 min blocks past 9:00 am
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Meeting)) {
                return false;
            }
            final Meeting meeting = (Meeting) o;
            return startTime == meeting.startTime && endTime == meeting.endTime;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = result * 31 + startTime;
            result = result * 31 + endTime;
            return result;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", startTime, endTime);
        }
    }

    public static List<Meeting> mergeRanges(List<Meeting> meetings) {

        if (meetings == null || meetings.isEmpty()) {
            return new ArrayList<>();
        }
        // merge meetings ranges


        Collections.sort(meetings, Comparator.comparingInt(Meeting::getStartTime));

        List<Meeting> mergedMeetings = new ArrayList<>();

        Iterator<Meeting> it = meetings.iterator();
        Meeting firstMeeting = it.next();
        Meeting currentMeeting = new Meeting(firstMeeting.startTime, firstMeeting.endTime);
        while (it.hasNext()) {
            Meeting nextMeeting = it.next();
            if (currentMeeting.endTime >= nextMeeting.startTime) {
                currentMeeting.endTime = Math.max(currentMeeting.endTime, nextMeeting.endTime);
            } else {
                mergedMeetings.add(currentMeeting);
                currentMeeting = new Meeting(nextMeeting.startTime, nextMeeting.endTime);
            }
            if (!it.hasNext()) {
                mergedMeetings.add(currentMeeting);
            }
        }

        return mergedMeetings;
    }

}
