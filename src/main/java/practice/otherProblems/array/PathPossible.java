package practice.otherProblems.array;

import java.util.Stack;

/**
 * amazon-interview-questions
 * 0
 * of 0 votes
 * 7
 * Answers
 * <p/>
 * Suppose you are given a puzzle that is represented as a matrix with 0s and 1s,
 * where a 0 indicates you’re allowed to move into that position
 * and 1 means you’re not allowed to move in that position.
 * Write a function that given a start position and an end position,
 * returns a boolean value indicating if there exists a path from start to end.
 * you are only allowed to move up, left, right and down. Diagonal movement is not allowed.
 * <p/>
 * Example #1
 * Input
 * 0 0 1 0 1
 * 0 0 0 0 0
 * 0 1 1 1 1
 * 0 1 1 0 0
 * <p/>
 * start: 1, 4
 * end 3,0
 * <p/>
 * Output - true
 * <p/>
 * Example #2
 * Input
 * 0 0 1 1 1
 * 0 1 0 0 0
 * 1 1 1 1 1
 * 0 0 0 0 1
 * <p/>
 * start: 0,0
 * end: 2,1
 * <p/>
 * Output - false
 *
 * @author Yashraj R. Sontakke
 */
public class PathPossible {

    public boolean isPathPossible(int[][] a, Point start, Point end){
        if (a== null || start == null || end == null){
            return false;
        }
        if (a.length ==0 || a[0].length == 0){
            return false;
        }

        boolean[][] visited = new boolean[a.length][a[0].length];
        Stack<Point> stack = new Stack<Point>();
        stack.push(start);
        while (!stack.isEmpty()){
            Point point = stack.pop();
            if (point.x ==end.x  && point.y == end.y){
                return true;
            }
            if (point.x < 0 || point.y < 0 || point.x >= a.length || point.y >= a[0].length || a[point.x][point.y] ==1
                     || visited[point.x][point.y]){
                continue;
            }
            visited[point.x][point.y] = true;
            stack.add(new Point(point.x-1,point.y));
            stack.add(new Point(point.x+1,point.y));
            stack.add(new Point(point.x,point.y-1));
            stack.add(new Point(point.x,point.y+1));

        }
        return false;
    }

    public static void main(String[] args){
        PathPossible p = new PathPossible();
        int[][] a = {{0, 0, 1, 0, 1}, {0, 0, 0, 0, 0}, {0, 1, 1, 1, 1}, {0, 1, 1, 0, 0}};

        Point start = new Point(1, 4);
        Point end = new Point(3, 0);
        System.out.println(p.isPathPossible(a, start, end));


        int[][] a1 = {{0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 1, 1, 1, 1}, {0, 0, 0, 0, 1}};

        Point start1 = new Point(0,0);
        Point end1 = new Point(2, 1);
        System.out.println(p.isPathPossible(a1, start1, end1));
    }
}
