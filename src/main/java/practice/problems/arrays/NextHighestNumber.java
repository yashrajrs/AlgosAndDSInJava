package practice.problems.arrays;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: yashrajsontakke
 * Date: 6/12/15
 * Time: 7:51 PM
 * To change this template use File | Settings | File Templates.
 *
 * @author Yashraj R. Sontakke
 */
public class NextHighestNumber {

    public void findNextHighestNumber(int[] a){
        int cur = a[a.length-1];
        int j = a.length-2;
        // Find the first smaller element from right
        while(j>=0){
            if (a[j] < cur){
                break;
            }
            cur = a[j];
            j--;
        }
        if (j==-1){
            return;
        }
        // Find the lowest element next to j
        int lowest = -1;
        for (int i=j+1;i<a.length;i++){
            if (lowest == -1 || a[i] < a[lowest]){
                lowest = i;

            }
        }
        System.out.println("lowest " + lowest);
        swap(a, j, lowest);
//
//        for (int i=0;i<a.length;i++){
//            System.out.print(a[i] + " ");
//        }
//        System.out.println();
        sort(a, j+1);


        for (int i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public void sort(int[] a, int index){
        int[] b = new int[a.length - index];
        int j =0 ;
        for (int i=index;i<a.length;i++){
            b[j] = a[i];
            j++;
        }
        Arrays.sort(b);
        j = 0;
        for (int i=index;i<a.length;i++){
            a[i] = b[j];
            j++;
        }
    }

    public void swap(int[] a, int x, int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static void main(String[] args){
        NextHighestNumber n = new NextHighestNumber();

        // Input 534976
        // Output 536479
        int[] a = {5,3,4,9,7,6};
        n.findNextHighestNumber(a);

//        // Input 218765
//        // Output 251678
//        int[] b = {2,1,8,7,6,5};
//        n.findNextHighestNumber(b);
//
//        // Input 1234
//        // Output 1243
//        int[] c = {1,2,3,4};
//        n.findNextHighestNumber(c);
//
//        // Input 4321
//        // Output
//        int[] d = {4,3,2,1};
//        n.findNextHighestNumber(d);
//
//        // Input 534976
//        // Output 536479
//        int[] e = {5,3,4,9,7,6};
//        n.findNextHighestNumber(e);


    }
}
