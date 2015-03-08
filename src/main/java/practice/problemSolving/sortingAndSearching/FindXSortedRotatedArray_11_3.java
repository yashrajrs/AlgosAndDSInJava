package practice.problemSolving.sortingAndSearching;

/**
 * Given a sorted array of n integers that has been rotated an unknown number of
 * times, write code to find an element in the array. You may assume that the array was
 * originally sorted in increasing order.
 * EXAMPLE
 * Input: find 5 in {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}
 * Output: 8 (the index of 5 in the array)
 *
 * @author Yashraj R. Sontakke
 */
public class FindXSortedRotatedArray_11_3 {

    public int search(int[] a, int x, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (a[mid] == x) {
            return mid;
        }
        if (a[left] < a[mid]) {
            if (a[left] < x && x < a[mid]) {
                return search(a, x, left, mid - 1);
            } else {
                return search(a, x, mid + 1, right);
            }
        } else if (a[left] > a[mid]) {
            if (a[mid] < x && x < a[right]) {
                return search(a, x, mid + 1, right);
            } else {
                return search(a, x, left, mid - 1);
            }
        } else if (a[left] == a[mid]) {
            if (a[right] != a[mid]) {
                return search(a, x, mid + 1, right);
            } else {
                int result = search(a, x, left, mid - 1);
                if (result == -1) {
                    return search(a, x, mid + 1, right);
                }
                return result;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindXSortedRotatedArray_11_3 findXSortedRotatedArray = new FindXSortedRotatedArray_11_3();
        int[] input = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        System.out.println(findXSortedRotatedArray.search(input, 5, 0, input.length - 1));
    }

}
