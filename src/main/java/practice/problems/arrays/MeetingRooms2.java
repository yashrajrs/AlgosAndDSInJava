package practice.problems.arrays;

import practice.otherProblems.array.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

 Example 1:

 Input: [[0, 30],[5, 10],[15, 20]]
 Output: 2
 Example 2:

 Input: [[7,10],[2,4]]
 Output: 1
 */
public class MeetingRooms2 {

    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b){
                return a.start-b.start;
            }
        });
        int count = 1;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(intervals[0].end);

        for(int i=1;i<intervals.length;i++) {
            if (intervals[i].start < queue.peek()) {
                count++;
            } else {
                queue.poll();
            }
            queue.offer(intervals[i].end);
        }
        return count;
    }
    public static void main(String[] args) {
        MeetingRooms2 meetingRooms = new MeetingRooms2();
        Interval[] intervals1 = {new Interval(0, 30), new Interval(5, 10), new Interval(15, 20)};
        System.out.println(meetingRooms.minMeetingRooms(intervals1));

        Interval[] intervals2 = {new Interval(7, 10), new Interval(2, 4)};
        System.out.println(meetingRooms.minMeetingRooms(intervals2));
    }
}
