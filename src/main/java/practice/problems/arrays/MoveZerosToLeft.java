package practice.problems.arrays;

import java.util.Arrays;

/**
 * Move all zeros to beginning input {1,2,3,0,0,0,4,5} output {0,0,0,1,2,3,4,5}
 *
 * @author Yashraj R. Sontakke
 */
public class MoveZerosToLeft {

    public void move(Integer[] a){
        int  j = a.length-1;
        for(int i= a.length-1;i>=0;i--){
            if (a[i] == 0){
                continue;
            }
            a[j] = a[i];
            j--;
        }
        while(j>=0){
            a[j] = 0;
            j--;
        }
    }

    private void move1(Integer[] a){
        int j = a.length-1;
        for(int i=a.length-1;i>=0;i--){
            if (a[0] == 0){
                continue;
            }
            a[j] = a[i];
            j--;
        }
        while(j>=0){
            a[j] = 0;
            j--;
        }
    }

    public static void main(String[] args){
        MoveZerosToLeft m = new MoveZerosToLeft();
        Integer[] a = {1,2,3,0,0,0,4,5};
        m.move(a);
        System.out.println(Arrays.asList(a).toString());
    }
}
