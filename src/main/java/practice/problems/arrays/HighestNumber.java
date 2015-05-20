package practice.problems.arrays;

/**
 * Created with IntelliJ IDEA.
 * User: yashrajsontakke
 * Date: 5/18/15
 * Time: 10:13 PM
 * To change this template use File | Settings | File Templates.
 *
 * @author Yashraj R. Sontakke
 */
public class HighestNumber {

    public Integer highest(char[] array, int index){
        Integer highestNumber = Integer.MIN_VALUE;
        if (index == array.length){

            Integer number = Integer.parseInt(new String(array));
            return number > highestNumber ? number : highestNumber;
        }
        for (int i =0;i<array.length;i++){
            swap(array, index, i);
            Integer number = highest(array, index+1);
            highestNumber = highestNumber > number ? highestNumber : number;
            swap(array, index, i);
        }
        return highestNumber;
    }

    public void swap(char[] array, int i, int j){
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args){
        HighestNumber n = new HighestNumber();
        char[] array = {'2','1','8','7','6','5'};

        System.out.println(n.highest(array, 0));
    }

}
