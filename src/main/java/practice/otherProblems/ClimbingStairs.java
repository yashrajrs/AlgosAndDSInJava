package practice.otherProblems;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.

 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * @author Yashraj R. Sontakke
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int[] map = new int[n+1];
        map[0] = 0;
        map[1] = 1;
        map[2] = 2;

        for(int i=3;i<=n;i++){
            map[i] = map[i-1] + map[i-2];
        }
        return map[n];
    }

    public static void main(String[] args){
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(1));
        System.out.println(climbingStairs.climbStairs(2));
        System.out.println(climbingStairs.climbStairs(3));
        System.out.println(climbingStairs.climbStairs(4));
    }
}
