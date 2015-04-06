package practice.problems.others;


import java.util.Arrays;

/**
 * Three segments of lengths A, B, C form a triangle iff
 *
 *      A + B > C
 *      B + C > A
 *      A + C > B
 *
 * e.g.
 *  6, 4, 5 can form a triangle
 * 10, 2, 7 can't
 *
 * Given a list of segments lengths algorithm should find at least one triplet of segments that form a triangle (if any).
 *
 * Method should return an array of either:
 * - 3 elements: segments that form a triangle (i.e. satisfy the condition above)
 * - empty array if there are no such segments

 *
 * @author Yashraj R. Sontakke
 */
public class TriangleTriplets {

     public void getTriplets(int[] arr){
         if (arr.length < 3){
             return;
         }
         Arrays.sort(arr);

         int i =0;
         int j =1;

         int[] output = new int[3];
         for (int k=2;k<arr.length;k++){
             if (isTriplet(arr[i],arr[j],arr[k])){
                 output[0] = arr[i];
                 output[1] = arr[j];
                 output[2] = arr[k];
                 break;
             }
             i++;
             j++;
         }
         if (output[0] ==0){
             return;
         }
         for ( i=0;i<output.length;i++){
             System.out.print(output[i] + " ");
         }
         System.out.println();
     }

    public boolean isTriplet(int a, int b, int c){
        if (a+b < c){
            return false;
        }
        if(a+c < b){
            return false;
        }
        if (b+c < a){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        TriangleTriplets t = new TriangleTriplets();
        int[] input = {1,2,3,4,5,7};
        t.getTriplets(input);
    }
}
