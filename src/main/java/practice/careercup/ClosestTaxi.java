package practice.careercup;

import java.util.AbstractList;
import java.util.ArrayList;

/**
 * You want to design a Cab system which will show you nearest 5 taxis.
 Each taxi will continuously emit (x,y) coordinates.
 You need to print the nearest taxi from (p,q).


 */
public class ClosestTaxi {


    public Point closestTaxi(Point customer, ArrayList<Point> taxis) {
         double minDistance = Double.MAX_VALUE;
         Point closestTaxi = null;
        for (Point taxi : taxis) {
            double distance = distance(customer, taxi);
            if (distance < minDistance) {
                minDistance = distance;
                closestTaxi = taxi;
            }
        }
        return closestTaxi;
    }

    public double distance(Point p1, Point p2) {
        int x = Math.abs(p1.getX() - p2.getX());
        int y = Math.abs(p1.getY() - p2.getY());

        return Math.sqrt(x*x + y*y);
    }

    public static void main(String[] args) {
        ClosestTaxi c = new ClosestTaxi();
        Point taxi1 = new Point(7,7);
        Point taxi2 = new Point(1,2);
        Point taxi3 = new Point(17,7);
        Point taxi4 = new Point(9,8);
        Point taxi5 = new Point(2,3);

        Point customer = new Point(5,5);

        ArrayList<Point> taxis = new ArrayList<Point>();
        taxis.add(taxi1);
        taxis.add(taxi2);
        taxis.add(taxi3);
        taxis.add(taxi4);
        taxis.add(taxi5);

        System.out.println(c.closestTaxi(customer, taxis));
    }
}
