package practice.otherProblems.array;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * <p/>
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 *
 * @author Yashraj R. Sontakke
 */
public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        List<Interval> result = new ArrayList<Interval>();
        Collections.sort(intervals, new IntervalComparator());
        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (prev.end >= current.start) {
                Interval merged = new Interval(prev.start, Math.max(prev.end, current.end));
                prev = merged;
            } else {
                result.add(prev);
                prev = current;
            }

        }
        result.add(prev);
        return result;
    }

    class IntervalComparator implements Comparator<Interval>

    {
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    }


    public static void main(String[] args) {
        MergeIntervals m = new MergeIntervals();
        ArrayList<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(2, 6));
        input.add(new Interval(8, 10));
        input.add(new Interval(15, 18));

        System.out.println(m.merge(input));
    }

}
