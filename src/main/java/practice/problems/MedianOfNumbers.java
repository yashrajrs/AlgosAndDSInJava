package practice.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Numbers are randomly generated and passed to a method. Write a program to find
 * and maintain the median value as new values are generated.
 *
 * @author Yashraj R. Sontakke
 */
public class MedianOfNumbers {

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(100, new MinHeapComparator());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(100, new MinHeapComparator());


    public void addNumber(int randomNumber) {
        if (maxHeap.size() == minHeap.size()) {
            if (minHeap.peek() != null && randomNumber > minHeap.peek()) {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(randomNumber);
            } else {
                maxHeap.offer(randomNumber);
            }
        } else {
            if (randomNumber < maxHeap.peek()) {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(randomNumber);
            } else {
                minHeap.offer(randomNumber);
            }
        }
    }


    public double getMedian() {
        if (maxHeap.isEmpty()) {
            return 0;
        }
        if (maxHeap.size() == minHeap.size()) {
            return ((double) maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            return maxHeap.peek();
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
        medianOfNumbers.addNumber(10);
        medianOfNumbers.addNumber(15);
        medianOfNumbers.addNumber(20);
        medianOfNumbers.addNumber(5);
        medianOfNumbers.addNumber(30);
        medianOfNumbers.addNumber(40);

        System.out.println(medianOfNumbers.getMedian());
    }
}
