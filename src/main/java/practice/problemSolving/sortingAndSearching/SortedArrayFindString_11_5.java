package practice.problemSolving.sortingAndSearching;

import java.util.Arrays;
import java.util.List;

/**
 * Given a sorted array of strings which is interspersed with empty strings, write a
 * method to find the location of a given string.
 * EXAMPLE
 * Input: find "ball" in {"at", "", "", "", "ball", "", "", "car",
 * "", "", "dad", "", ""}
 * Output: 4
 *
 * @author Yashraj R. Sontakke
 */
public class SortedArrayFindString_11_5 {

    /**
     * First approach
     */
    public Integer getLocation(List<String> input, String search) {
        int i = 0, j = input.size() - 1;
        while (i <= j) {
            if (input.get(i).equals(search)) {
                return i;
            } else if (input.get(j).equals(search)) {
                return j;
            } else {
                i++;
                j--;
            }
        }
        return -1;
    }

    public Integer getLocation(List<String> input, String search, int first, int last) {
        if (first > last) {
            return -1;
        }
        int mid = (first + last) / 2;

        if (input.get(mid).isEmpty()) {
            int left = mid - 1;
            int right = mid + 1;
            while (true) {
                if (left < first && right > last) {
                    return -1;
                } else if (left >= first && !input.get(left).isEmpty()) {
                    mid = left;
                    break;
                } else if (right <= last && !input.get(right).isEmpty()) {
                    mid = right;
                    break;
                } else {
                    left--;
                    right++;
                }
            }
        }
        if (search.equals(input.get(mid))) {
            return mid;
        } else if (input.get(mid).compareTo(search) < 0) {
            return getLocation(input, search, mid + 1, last);
        } else {
            return getLocation(input, search, first, mid - 1);
        }
    }


    public static void main(String[] args) {
        SortedArrayFindString_11_5 s = new SortedArrayFindString_11_5();
        List<String> input = Arrays.asList("at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "");
        String search = "ball";
        Integer output = s.getLocation(input, search);
        if (output != -1) {
            System.out.println(String.format("Location of string \"%s\" in input array is %d", search, output));
        } else {
            System.out.println(String.format("String %s is not present in the array", search));
        }

        Integer output2 = s.getLocation(input, search, 0, input.size() - 1);
        if (output2 != -1) {
            System.out.println(String.format("Location of string \"%s\" in input array is %d", search, output2));
        } else {
            System.out.println(String.format("String %s is not present in the array", search));
        }

    }

}
