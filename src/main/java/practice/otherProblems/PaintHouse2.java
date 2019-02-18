package practice.otherProblems;

/**
 * There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

 The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

 Note:
 All costs are positive integers.

 Example:

 Input: [[1,5,3],[2,9,4]]
 Output: 5
 Explanation: Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5;
 Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5.
 Follow up:
 Could you solve it in O(nk) runtime?
 */
public class PaintHouse2 {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int preMin = 0;
        int preSecond = 0;
        int preIndex = -1;

        for(int i=0;i<costs.length;i++) {
            int currMin = Integer.MAX_VALUE;
            int curSecond = Integer.MAX_VALUE;
            int curIndex = 0;

            for (int j=0;j<costs[0].length;j++) {
                if (preIndex == j) {
                    costs[i][j]+= preSecond;
                } else {
                    costs[i][j] += preMin;
                }
                if (currMin > costs[i][j]) {
                    curSecond = currMin;
                    currMin = costs[i][j];
                    curIndex = j;
                } else if (curSecond > costs[i][j]){
                    curSecond = costs[i][j];
                }

                preMin = currMin;
                preSecond = curSecond;
                preIndex = curIndex;
            }
        }
        int result = Integer.MAX_VALUE;
        for (int j=0;j<costs[0].length;j++) {
            if (result > costs[costs.length-1][j]) {
                result = costs[costs.length-1][j];
            }
        }
        return result;
    }

    public static void main(String[] args){
        PaintHouse2 p = new PaintHouse2();
        int[][] costs = {{1,5,3},{2,9,4}};
        System.out.println(p.minCostII(costs));
    }
}
