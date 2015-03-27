package practice.problems.others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Numbers are randomly generated and passed to a method. Write a program to find
 * and maintain the median value as new values are generated.
 *
 * @author Yashraj R. Sontakke
 */
public class MedianOfNumbers {

    private ArrayList<Integer> lowPQ = new ArrayList<Integer>();
    private ArrayList<Integer> highPQ = new ArrayList<Integer>();

    public void addElement(int randomNumber) {
        if (highPQ.isEmpty()) {
            highPQ.add(randomNumber);
        } else if (lowPQ.isEmpty()) {
            if (randomNumber > highPQ.get(highPQ.size() - 1)) {
                lowPQ.add(highPQ.remove(highPQ.size() - 1));
                highPQ.add(randomNumber);
            } else {
                lowPQ.add(randomNumber);
            }
        } else if (highPQ.size() == lowPQ.size()) {
            if (randomNumber > highPQ.get(highPQ.size() - 1)) {
                highPQ.add(randomNumber);
            } else {
                highPQ.add(lowPQ.remove(0));
                lowPQ.add(randomNumber);
            }
        } else {
            if (randomNumber > highPQ.get(highPQ.size() - 1)) {
                lowPQ.add(highPQ.remove(highPQ.size() - 1));
                highPQ.add(randomNumber);
            } else {
                lowPQ.add(randomNumber);
            }
        }
        Collections.sort(lowPQ, new MinHeapComparator());
        Collections.sort(highPQ, new MinHeapComparator());
    }


    public double getMedian() {
        if (highPQ.isEmpty()) {
            return 0;
        }
        if (highPQ.size() == lowPQ.size()) {
            return ((double) lowPQ.get(0) + highPQ.get(highPQ.size() - 1)) / 2;
        } else {
            return highPQ.get(highPQ.size() - 1);
        }
    }

    public class MinHeapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer integer, Integer integer2) {
            if (integer > integer2) {
                return -1;
            } else if (integer == integer2) {
                return 0;
            }
            return 1;
        }
    }


    public static void main(String[] args) {
        MedianOfNumbers medianOfNumbers = new MedianOfNumbers();
        medianOfNumbers.addElement(10);
        medianOfNumbers.addElement(15);
        medianOfNumbers.addElement(20);
        medianOfNumbers.addElement(5);
        medianOfNumbers.addElement(30);
        medianOfNumbers.addElement(40);

        System.out.println(medianOfNumbers.getMedian());
    }
}
