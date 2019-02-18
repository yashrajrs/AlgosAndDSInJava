package practice.otherProblems;

import java.util.HashMap;

/**
 * Design and implement a TwoSum class. It should support the following operations: add and find.

 add - Add the number to an internal data structure.
 find - Find if there exists any pair of numbers which sum is equal to the value.

 Example 1:

 add(1); add(3); add(5);
 find(4) -> true
 find(7) -> false
 Example 2:

 add(3); add(1); add(2);
 find(3) -> true
 find(6) -> false
 */
public class TwoSum3 {
    private HashMap<Integer, Integer> elements = new HashMap<Integer, Integer>();
    /** Initialize your data structure here. */
    public TwoSum3() {
        this.elements = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(elements.containsKey(number)) {
            elements.put(number, elements.get(number)+1);
        } else {
            elements.put(number, 1);
        }
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(Integer i:elements.keySet()) {
            int target = value -i;
            if(elements.containsKey(target)) {
                if(target == i && elements.get(target) <2) {
                    continue;
                }
                return true;
            }
        }
        return false;
    }
}
