package practice.otherProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

 Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.

 Example 1:

 Input: [[1,1],2,[1,1]]
 Output: 8
 Explanation: Four 1's at depth 1, one 2 at depth 2.
 Example 2:

 Input: [1,[4,[6]]]
 Output: 17
 Explanation: One 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17.
 */
public class NestedListWeightSum2 {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.isEmpty()) {
            return 0;
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Stack<NestedInteger> stack = new Stack<>();
        Stack<Integer> layers = new Stack<>();

        for (NestedInteger n: nestedList) {
            stack.push(n);
            layers.push(1);
        }
        int maxLayer = Integer.MIN_VALUE;
        while (!stack.isEmpty()) {
            NestedInteger top = stack.pop();
            Integer layer = layers.pop();

            maxLayer = Math.max(maxLayer, layer);

            if(top.isInteger()) {
                if (map.containsKey(layer)) {
                    map.get(layer).add(top.getInteger());
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(top.getInteger());
                    map.put(layer, list);
                }
            } else {
                for(NestedInteger in:top.getList()) {
                    stack.push(in);
                    layers.push(layer+1);
                }
            }
        }
        int result = 0;
        for (int i= maxLayer; i>=1;i--) {
            if (map.get(i) != null) {
                for (int v:map.get(i)) {
                    result += v*(maxLayer-i+1);
                }
            }
        }
        return result;
    }

    public interface NestedInteger {


        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
