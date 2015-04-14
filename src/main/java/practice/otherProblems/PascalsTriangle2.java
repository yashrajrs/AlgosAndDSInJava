package practice.otherProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.

 * For example, given k = 3,
 * Return [1,3,3,1].

 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 *
 * @author Yashraj R. Sontakke
 */
public class PascalsTriangle2 {

    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(rowIndex<0){
            return result;
        }
        result.add(1);
        for(int i=1;i<=rowIndex;i++){
            for(int j=result.size()-2;j>=0;j--){
                result.set(j+1,result.get(j) + result.get(j+1));
            }
            result.add(1);
        }
        return result;
    }

    public static void main(String[] args){
        PascalsTriangle2 p  = new PascalsTriangle2();
        List<Integer> result = p.getRow(4);
        System.out.println(result.toString());

        result = p.getRow(3);
        System.out.println(result.toString());

        result = p.getRow(0);
        System.out.println(result.toString());
    }
}
