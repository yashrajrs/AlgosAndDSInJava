package practice.problems.others;

/**
 * given an array of integers A[1..n], make a new array B[1..n]
 * where B[i] is the product of everything in A excluding A[i]. O(n) solution without division.
 *
 * @author Yashraj R. Sontakke
 */
public class IntegerMultiplicationArray {

    public void getArray(int[] input){
        int product = 1;
        for (int i=0;i<input.length;i++){
            product = product* input[i];
        }

        System.out.println(product);
        int[] output= new int[input.length];

        for (int i=0;i<input.length;i++){
            output[i] = divide(product,input[i]);
            System.out.println(output[i]);
        }
    }

    public int divide(int a, int b) {
        if (a < b) {
            return 0;
        }
        return 1 + divide(a - b, b);
    }

    public static void main(String[] args){
        int[] input = {1,2,3,4,5};
        IntegerMultiplicationArray integerMultiplicationArray = new IntegerMultiplicationArray();
        integerMultiplicationArray.getArray(input);
    }
}
