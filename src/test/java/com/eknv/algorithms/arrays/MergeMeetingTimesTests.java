package com.eknv.algorithms.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.eknv.algorithms.arrays.MergeMeetingTimes.mergeRanges;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeMeetingTimesTests {

    @Test
    public void meetingsOverlapTest() {
        final List<MergeMeetingTimes.Meeting> meetings = Arrays.asList(new MergeMeetingTimes.Meeting(1, 3), new MergeMeetingTimes.Meeting(2, 4));
        final List<MergeMeetingTimes.Meeting> actual = mergeRanges(meetings);
        final List<MergeMeetingTimes.Meeting> expected = Arrays.asList(new MergeMeetingTimes.Meeting(1, 4));
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void meetingsTouchTest() {
        final List<MergeMeetingTimes.Meeting> meetings = Arrays.asList(new MergeMeetingTimes.Meeting(5, 6), new MergeMeetingTimes.Meeting(6, 8));
        final List<MergeMeetingTimes.Meeting> actual = mergeRanges(meetings);
        final List<MergeMeetingTimes.Meeting> expected = Arrays.asList(new MergeMeetingTimes.Meeting(5, 8));
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void meetingContainsOtherMeetingTest() {
        final List<MergeMeetingTimes.Meeting> meetings = Arrays.asList(new MergeMeetingTimes.Meeting(1, 8), new MergeMeetingTimes.Meeting(2, 5));
        final List<MergeMeetingTimes.Meeting> actual = mergeRanges(meetings);
        final List<MergeMeetingTimes.Meeting> expected = Arrays.asList(new MergeMeetingTimes.Meeting(1, 8));
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void meetingsStaySeparateTest() {
        final List<MergeMeetingTimes.Meeting> meetings = Arrays.asList(new MergeMeetingTimes.Meeting(1, 3), new MergeMeetingTimes.Meeting(4, 8));
        final List<MergeMeetingTimes.Meeting> actual = mergeRanges(meetings);
        final List<MergeMeetingTimes.Meeting> expected = Arrays.asList(
                new MergeMeetingTimes.Meeting(1, 3), new MergeMeetingTimes.Meeting(4, 8)
        );
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void multipleMergedMeetingsTest() {
        final List<MergeMeetingTimes.Meeting> meetings = Arrays.asList(
                new MergeMeetingTimes.Meeting(1, 4), new MergeMeetingTimes.Meeting(2, 5), new MergeMeetingTimes.Meeting(5, 8));
        final List<MergeMeetingTimes.Meeting> actual = mergeRanges(meetings);
        final List<MergeMeetingTimes.Meeting> expected = Arrays.asList(new MergeMeetingTimes.Meeting(1, 8));
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void meetingsNotSortedTest() {
        final List<MergeMeetingTimes.Meeting> meetings = Arrays.asList(
                new MergeMeetingTimes.Meeting(5, 8), new MergeMeetingTimes.Meeting(1, 4), new MergeMeetingTimes.Meeting(6, 8));
        final List<MergeMeetingTimes.Meeting> actual = mergeRanges(meetings);
        final List<MergeMeetingTimes.Meeting> expected = Arrays.asList(
                new MergeMeetingTimes.Meeting(1, 4), new MergeMeetingTimes.Meeting(5, 8)
        );
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void oneLongMeetingContainsSmallerMeetingsTest() {
        final List<MergeMeetingTimes.Meeting> meetings = Arrays.asList(
                new MergeMeetingTimes.Meeting(1, 10), new MergeMeetingTimes.Meeting(2, 5), new MergeMeetingTimes.Meeting(6, 8),
                new MergeMeetingTimes.Meeting(9, 10), new MergeMeetingTimes.Meeting(10, 12)
        );
        final List<MergeMeetingTimes.Meeting> actual = mergeRanges(meetings);
        final List<MergeMeetingTimes.Meeting> expected = Arrays.asList(
                new MergeMeetingTimes.Meeting(1, 12)
        );
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void sampleInputTest() {
        final List<MergeMeetingTimes.Meeting> meetings = Arrays.asList(
                new MergeMeetingTimes.Meeting(0, 1), new MergeMeetingTimes.Meeting(3, 5), new MergeMeetingTimes.Meeting(4, 8),
                new MergeMeetingTimes.Meeting(10, 12), new MergeMeetingTimes.Meeting(9, 10)
        );
        final List<MergeMeetingTimes.Meeting> actual = mergeRanges(meetings);
        final List<MergeMeetingTimes.Meeting> expected = Arrays.asList(
                new MergeMeetingTimes.Meeting(0, 1), new MergeMeetingTimes.Meeting(3, 8), new MergeMeetingTimes.Meeting(9, 12)
        );
        System.out.println(actual);
        assertEquals(expected, actual);
    }


}
