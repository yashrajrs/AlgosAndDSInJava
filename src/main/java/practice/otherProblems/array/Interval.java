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
    public int start;
    public int end;

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }
}