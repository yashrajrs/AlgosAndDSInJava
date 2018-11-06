package practice.otherProblems.array;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p/>
 * You may assume no duplicates in the array.
 * <p/>
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 *
 * @author Yashraj R. Sontakke
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return searchInsert(nums, target, 0, nums.length - 1);
    }

    private int searchInsert(int[] nums, int target, int left, int right) {
        int mid = (left + right) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return left < mid ? searchInsert(nums, target, left, mid - 1) : left;
        } else {
            return right > mid ? searchInsert(nums, target, mid + 1, right) : right + 1;
        }
    }

    public static void main(String[] args){
        SearchInsertPosition s = new SearchInsertPosition();
        int[] a = {1, 3, 5, 6};
        System.out.println(s.searchInsert(a, 5));
        System.out.println(s.searchInsert(a, 2));
        System.out.println(s.searchInsert(a, 7));
        System.out.println(s.searchInsert(a, 0));
    }
}
