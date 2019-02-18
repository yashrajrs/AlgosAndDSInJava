package practice.problems.arrays;

import java.util.HashMap;

/**
 * In a row of trees, the i-th tree produces fruit with type tree[i].

 You start at any tree of your choice, then repeatedly perform the following steps:

 Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
 Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
 Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.

 You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.

 What is the total amount of fruit you can collect with this procedure?



 Example 1:

 Input: [1,2,1]
 Output: 3
 Explanation: We can collect [1,2,1].
 Example 2:

 Input: [0,1,2,2]
 Output: 3
 Explanation: We can collect [1,2,2].
 If we started at the first tree, we would only collect [0, 1].
 Example 3:

 Input: [1,2,3,2,2]
 Output: 4
 Explanation: We can collect [2,3,2,2].
 If we started at the first tree, we would only collect [1, 2].
 Example 4:

 Input: [3,3,3,1,2,1,1,2,3,3,4]
 Output: 5
 Explanation: We can collect [1,2,1,1,2].
 If we started at the first tree or the eighth tree, we would only collect 4 fruits.


 Note:

 1 <= tree.length <= 40000
 0 <= tree[i] < tree.length
 */
public class FruitIntoBaskets {
    public int totalFruit(int[] tree) {
        int i=0;
        int ans = 0;
        Counter counter = new Counter();
        for(int j=0;j<tree.length;j++) {
            counter.add(tree[j], 1);
            while (counter.size() >= 3) {
                counter.add(tree[i], -1);
                if (counter.get(tree[i]) == 0) {
                    counter.remove(tree[i]);
                }
                i++;
            }

            ans = Math.max(ans, j-i+1);
        }
        return ans;
    }

    public class Counter extends HashMap<Integer, Integer> {
        public int get(int k) {
            return containsKey(k) ? super.get(k) : 0;
        }

        public void add(int k, int v) {
            put(k, get(k) + v);
        }

    }

    public static void main(String[] args){
        FruitIntoBaskets f = new FruitIntoBaskets();
        System.out.println(f.totalFruit(new int[]{1, 2, 1})); // 3
        System.out.println(f.totalFruit(new int[]{0,1,2,2})); // 3
        System.out.println(f.totalFruit(new int[]{1,2,3,2,2})); // 4
        System.out.println(f.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4})); // 5
    }
}
