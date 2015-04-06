package practice.problems.others;

/**
 * Find the number of set bits in a number.
 * 5 --> 101 --> 2
 * 3 --> 011 --> 2
 * 2 --> 010 --> 1
 *
 * @author Yashraj R. Sontakke
 */
public class NumberOfSetBits {

    public void numberOfOnes(int input) {
        int count = 0;
        while (input > 0) {
            input = input & (input - 1);
            count++;
        }
        System.out.println(String.format("Number of bits = %d", count));
    }

    public int hammingWeight(int n) {
        int count = 0;
        for(int i=1; i<33; i++){
            if(getBit(n, i) == true){
                count++;
            }
        }
        return count;
    }

    public boolean getBit(int n, int i){
        return (n & (1 << i)) != 0;
    }

    public static void main(String[] args) {
        NumberOfSetBits numberOfSetBits = new NumberOfSetBits();
        numberOfSetBits.numberOfOnes(5);
        numberOfSetBits.numberOfOnes(3);
        numberOfSetBits.numberOfOnes(2);
        System.out.println(numberOfSetBits.hammingWeight(Integer.MAX_VALUE));
    }
}
