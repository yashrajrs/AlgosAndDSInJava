package practice.problems.others;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Sort array as per priority. High priority is 1, medium 2 and low 3.
 *
 * @author Yashraj R. Sontakke
 */
public class SortByPriority {

    public int getPriority(String input) {
        if (input.length() == 1) {
            return 1;
        }
        if (input.length() == 2) {
            return 2;
        }
        return 3;
    }

    public void sort(String[] input) {
        HashMap<Integer, HashSet<String>> map = new HashMap<Integer, HashSet<String>>();

        for (String string : input) {
            int priority = getPriority(string);
            HashSet<String> set = map.get(priority);
            if (set == null) {
                set = new HashSet<String>();
                set.add(string);
            } else {
                set.add(string);
            }
            map.put(priority, set);
        }
        int i = 0;
        for (Integer key : map.keySet()) {
            for (String string : map.get(key)) {
                input[i] = string;
                i++;
            }
        }

        for (int j = 0; j < input.length; j++) {
            System.out.print(input[j] + " ");
        }
    }


    public void quickSort(String[] input, int left, int right) {
        int pivot = left + (right - left) / 2;

        int i = left;
        int j = right;
        while (i <= j) {
            while (getPriority(input[pivot]) > getPriority(input[i])) {
                i++;
            }
            while (getPriority(input[pivot]) < getPriority(input[j])) {
                j--;
            }

            if (i <= j) {
                String temp = input[i];
                input[i] = input[j];
                input[j] = temp;
                i++;
                j--;
            }
            if (left < j) {
                quickSort(input, left, j);
            }
            if (i < right) {
                quickSort(input, i, right);
            }
        }

    }

    public static void main(String[] args) {
        SortByPriority sortByPriority = new SortByPriority();
        String[] input = {"ABCD", "AB", "A", "DC", "AVFS", "V", "GB", "VFFVF"};
        sortByPriority.sort(input);

        System.out.println();

        sortByPriority.quickSort(input, 0, input.length - 1);
        for (int j = 0; j < input.length; j++) {
            System.out.print(input[j] + " ");
        }
    }
}
