package practice.problemSolving.recursion;

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

/**
 * Imagine a robot sitting on the upper left corner of an X by Y grid. The robot can
 * only move in two directions: right and down. How many possible paths are there
 * for the robot to go from (0,0) to (X,Y)?
 *
 * @author Yashraj R. Sontakke
 */
public class RobotLeftToRight_9_2 {

    public Set<ArrayList<Point>> paths = Sets.newHashSet();

    public void getPaths(Point currentPosition, ArrayList<Point> currentPath, Point finalPosition,
                         int xMax, int yMax) {
        if (currentPosition.getX() == finalPosition.getX() &&
                currentPosition.getY() == finalPosition.getY()) {
            paths.add(currentPath);
            return;
        } else if (currentPosition.getX() > finalPosition.getX() || currentPosition.getY() > finalPosition.getY()) {
            return;
        }

        if (currentPosition.getX() + 1 <= xMax && currentPosition.getY() <= yMax) {
            ArrayList<Point> newPath = new ArrayList<Point>(currentPath);
            Point newPoint = new Point(currentPosition.getX() + 1, currentPosition.getY());
            newPath.add(newPoint);
            getPaths(newPoint, newPath, finalPosition, xMax, yMax);
        }
        if (currentPosition.getX() <= xMax && currentPosition.getY() + 1 <= yMax) {
            ArrayList<Point> newPath = new ArrayList<Point>(currentPath);
            Point newPoint = new Point(currentPosition.getX(), currentPosition.getY() + 1);
            newPath.add(newPoint);
            getPaths(newPoint, newPath, finalPosition, xMax, yMax);
        }
    }

    public static void main(String[] args) {
        Point currentPoint = new Point(0, 0);
        Point finalPosition = new Point(1, 1);
        RobotLeftToRight_9_2 robotLeftToRight = new RobotLeftToRight_9_2();
        ArrayList<Point> currentPath = new ArrayList<Point>(Arrays.asList(currentPoint));
        robotLeftToRight.getPaths(currentPoint, currentPath, finalPosition, 4, 4);

        System.out.println(robotLeftToRight.paths.toString());
    }


}
