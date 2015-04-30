package practice.algorithms;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: yashrajsontakke
 * Date: 4/29/15
 * Time: 9:35 PM
 * To change this template use File | Settings | File Templates.
 *
 * @author Yashraj R. Sontakke
 */
public class InsertionSort {

    public void sort(Integer[] input){
        for(int j=0;j<input.length;j++){
            int key = input[j];
            int i = j-1;
            while (i>=0 && input[i] > key){
                input[i+1] = input[i];
                i--;
            }
            input[i+1] = key;
        }
    }


    public static void main(String[] args) {
        InsertionSort m = new InsertionSort();
        Integer[] input = {4, 2, 10, 3, 5, 1, 9, 7};
        m.sort(input);
        System.out.println("MERGED = " + Arrays.asList(input).toString());
    }
}
