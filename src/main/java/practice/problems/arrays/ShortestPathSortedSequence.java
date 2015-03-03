package practice.problems.arrays;

import com.google.common.collect.Sets;

import java.util.*;

/**
 * Given an array of integers, write a method to find indices m and n such that if you
 * sorted elements m through n, the entire array would be sorted. Minimize n - m
 * (that is, find the smallest such sequence).
 * EXAMPLE
 * Input: 1, 2, 3, 7, 10, 11, 4, 12, 9, 7, 16, 18, 19
 * Output: (3, 9)
 *
 * @author Yashraj R. Sontakke
 */
public class ShortestPathSortedSequence {

    public Set<Point> paths = Sets.newHashSet();


    public void getPaths(ArrayList<Integer> input, int start, int end) {
        if (start>=end){
            return;
        }

        if (start ==3 && end == 9){
            System.out.println();
        }
        if (isValid(input, 0,start) && isValid(input, end, input.size()-1)

                &&isValidEnds(input,start,end)){
            paths.add(new Point(start, end));
        }


    }

    public boolean isValidEnds(ArrayList<Integer> input, int start, int end){
        if (start>end){
            return false;
        }

        for (int i=start+1;i<=end-1;i++){
            if (input.get(i) < input.get(start)){
                return false;
            }
            if (input.get(i) > input.get(end)){
                return false;
            }
        }


        return true;
    }

    public boolean isValid(ArrayList<Integer> input, int start, int end){

        if (start>end){
            return false;
        }

        Integer value = input.get(start);
        for(int i=start+1;i<=end;i++){
            if (value > input.get(i)){
                return false;
            }
            value = input.get(i);
        }

       return true;
    }

    public void getShortestPoint(ArrayList<Integer> input, int start, int end){
        for (int i=0;i<input.size();i++){
            getPaths(input, start+i, end);
            getPaths(input, start, end-i);
            getPaths(input, start+i, end-i);
        }

        if (paths.isEmpty()){
            System.out.println("No shortest path");
            return;
        }

        Iterator<Point> iterator = paths.iterator();
        Point value = iterator.next();
        while (iterator.hasNext()){
            Point current = iterator.next();
            if (value.getDiff() > current.getDiff()){
                value =current;
            }
        }
        System.out.println(value);
    }


    public static void main(String[] args){
        ShortestPathSortedSequence shortestPathSortedSequence = new ShortestPathSortedSequence();
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19));
        shortestPathSortedSequence.getShortestPoint(input, 0, input.size() - 1);


    }


    public class Point{
        private final int start;
        private final int end;
        private final int diff;

        public Point(int start,int end){
            this.start =start;
            this.end = end;
            this.diff = end-start;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getDiff() {
            return diff;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (end != point.end) return false;
            if (start != point.start) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = start;
            result = 31 * result + end;
            return result;
        }
    }
}
