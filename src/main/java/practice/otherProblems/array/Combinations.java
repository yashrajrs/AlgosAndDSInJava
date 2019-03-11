package practice.otherProblems.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p/>
 * For example,
 * If n = 4 and k = 2, a solution is:
 * <p/>
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 *
 * @author Yashraj R. Sontakke
 */
public class Combinations {
    int count = 0;
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n <= 0 || n < k) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();

        dfs(n, k, 1, list, result);
        System.out.println(count);
        return result;
    }

    private void dfs(int n, int k, int start, ArrayList<Integer> list, List<List<Integer>> result) {
        if (list.size() == k) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            count++;
            dfs(n, k, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args){
        Combinations c = new Combinations();
        System.out.println(c.combine(4,2).toString());
        System.out.println(c.combine(4,3).toString());
    }
}
