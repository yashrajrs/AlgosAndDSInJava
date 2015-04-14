package practice.otherProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.

 * For example, given numRows = 5,
 * Return

 * [
 * [1],
 *[1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 *
 * @author Yashraj R. Sontakke
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows <= 0){
            return result;
        }
        ArrayList<Integer> previous = new ArrayList<Integer>();
        previous.add(1);
        result.add(previous);

        for(int i=2;i<=numRows;i++){
            ArrayList<Integer> current = new ArrayList<Integer>();
            current.add(1);
            for(int j=0;j<previous.size()-1;j++){
                current.add(previous.get(j) + previous.get(j+1));
            }
            current.add(1);
            result.add(current);
            previous = current;
        }
        return result;
    }

    public static void main(String[] args){
        PascalsTriangle p  = new PascalsTriangle();
        List<List<Integer>> result = p.generate(5);
        print(result);
    }

    public static void print(List<List<Integer>> input){
        for (int i=0;i<input.size();i++){
            System.out.println(input.get(i).toString());
        }
    }
}
