package practice.otherProblems;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that
 * adjacent houses have security system connected and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.

 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * @author Yashraj R. Sontakke
 */
public class HouseRobber {

    public int rob(int[] num) {
        if(num == null || num.length == 0){
            return 0;
        }
        int odd = 0;
        int even = 0;

        for(int i=0;i<num.length;i++){
            if(i%2==0){
                even += num[i];
                even = even > odd ? even : odd;
            }else{
                odd += num[i];
                odd = even > odd ? even : odd;
            }
        }
        return even > odd ? even : odd;
    }

    public static void main(String[] args){
       HouseRobber h = new HouseRobber();
        int[] input = {2,1,5,10,25};
        System.out.println(h.rob(input));
    }
}
