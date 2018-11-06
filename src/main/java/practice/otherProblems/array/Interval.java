package practice.otherProblems.array;

/**
 * Created with IntelliJ IDEA.
 * User: yashrajsontakke
 * Date: 7/4/15
 * Time: 9:45 PM
 * To change this template use File | Settings | File Templates.
 *
 * @author Yashraj R. Sontakke
 */
public class Interval {
    int start;
    int end;

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}