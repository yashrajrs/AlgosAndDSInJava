package practice.problemSolving;

/**
 * Write a function to swap a number in place (that is, without temporary variables).
 *
 * @author Yashraj R. Sontakke
 */
public class SwapNumbers {

    public void swap(Integer input1, Integer input2){
        input1 = input1 + input2;
        input2 = input1 - input2;
        input1 = input1 - input2;

        System.out.println(String.format("Input1 = %d",input1));
        System.out.println(String.format("Input2 = %d",input2));

    }

    public static void main(String[] args){
        Integer input1 = 10;
        Integer input2 = 5;
        SwapNumbers swapNumbers = new SwapNumbers();
        swapNumbers.swap(input1, input2);
        System.out.println(String.format("Input1 = %d",input1));
        System.out.println(String.format("Input2 = %d",input2));
    }
}
