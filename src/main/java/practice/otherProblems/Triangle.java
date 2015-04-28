package practice.otherProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.

 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 *
 * @author Yashraj R. Sontakke
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] total = new int[triangle.size()];
        int l = triangle.size()-1;

        for(int i=0; i< triangle.get(l).size(); i++){
            total[i] = triangle.get(l).get(i);
        }

        for(int i= triangle.size()-2; i>=0;i--){
            for(int j=0;j<triangle.get(i+1).size()-1;j++){
                total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j+1]);
            }
        }
        return total[0];
    }

    public static void main(String[] args){
        Triangle t = new Triangle();
        List<List<Integer>> input = new ArrayList<List<Integer>>();
        input.add(Arrays.asList(2));
        input.add(Arrays.asList(3,4));
        input.add(Arrays.asList(6,5,7));
        input.add(Arrays.asList(4,1,8,3));
        System.out.println(t.minimumTotal(input));
    }
}
