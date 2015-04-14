package practice.otherProblems;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.

 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * @author Yashraj R. Sontakke
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int add = 1;
        for(int i = digits.length-1; i>=0;i--){
            int sum = digits[i] + add;
            digits[i] = sum %10;
            add = sum/10;
            if(add == 0){
                return digits;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = add;
        for(int i=0;i<digits.length;i++){
            result[i+1] = digits[i];
        }
        return result;
    }

    public static void main(String[] args){
        PlusOne p = new PlusOne();
        int[] a = {1,2,3,4};
        print(p.plusOne(a));

        int[] b = {1,2,3,9};
        print(p.plusOne(b));

        int[] c = {9,9,9};
        print(p.plusOne(c));

    }

    public static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]);
        }
        System.out.println();
    }
}
