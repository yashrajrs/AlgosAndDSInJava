package practice.otherProblems;

/**
 * Find the number which is not repeated in Array of integers, others are present for two times.

 * e.g. Input : 23, 34,56,21,21,56,78,23, 34
 * Output: 78
 * Hint: USE XOR
 *
 * @author Yashraj R. Sontakke
 */
public class SingleNumberPresentOnce {

    public int getNumberPresentOnce(int[] input){
        if (input == null || input.length == 0){
            return -1;
        }
        int result = input[0];
        for(int i =1;i<input.length;i++){
            result = result^ input[i];
        }

        return result;
    }

    public static void main(String[] args){
        SingleNumberPresentOnce s = new SingleNumberPresentOnce();
        int[] input = {23, 34,56,21,21,56,78,23, 34};
        System.out.println(s.getNumberPresentOnce(input));
    }
}
