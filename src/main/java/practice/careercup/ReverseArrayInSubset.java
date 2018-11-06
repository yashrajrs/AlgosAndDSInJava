package practice.careercup;

/**
 * Reverse an array in subset of N. Example:
 input: Array = [1,2,3,4,5,6,7,8,9], N = 3
 output: [3,2,1,6,5,4,9,8,7]


 */
public class ReverseArrayInSubset {

    public void reverse(int[] in, int length) {
        for (int i=0;i<in.length-length+1; i+=length) {
            int start = i;
            int end = i+length-1;
            while (start < end) {
                int temp = in[start];
                in[start] = in[end];
                in[end] = temp;
                start++;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        ReverseArrayInSubset r = new ReverseArrayInSubset();
        int[] in = {1,2,3,4,5,6,7,8,9};
        r.reverse(in, 3);
        for (int i=0;i<in.length;i++) {
            System.out.print(in[i] + " ");
        }
    }
}
