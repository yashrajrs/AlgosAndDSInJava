package practice.problems.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by yashraj on 2/24/19.
 */
public class RandomizedSet {
    ArrayList<Integer> nums;
    Map<Integer, Integer> locs;
    Random random = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<>();
        locs = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contains = locs.containsKey(val);
        if (contains){
            return false;
        }
        locs.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean contains = locs.containsKey(val);
        if (!contains) {
            return false;
        }
        int loc = locs.get(val);
        if (loc < nums.size()-1) {
            int lastLoc = nums.get(nums.size()-1);
            nums.set(loc, lastLoc);
            locs.put(lastLoc, loc);
        }
        locs.remove(val);
        nums.remove(nums.size()-1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}
