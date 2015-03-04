package practice.problems;

import java.util.Random;

/**
 * Implement a method rand70 given randSQ- That is, given a method that generates
 * a random number between 0 and 4 (inclusive), write a method that generates a
 * random number between 0 and 6 (inclusive).
 *
 * @author Yashraj R. Sontakke
 */
public class Random7Generator {
    Random random = new Random();

    public int rand7(){
        while (true){
            int number = 5 * rand5() + rand5();
            if (number <21){
                return number%7;
            }
        }
    }

    public int rand5(){
        return random.nextInt(5) +1;
    }

    public static void main(String[] args){
        Random7Generator random7Generator = new Random7Generator();
        System.out.println(random7Generator.rand7());
        System.out.println(random7Generator.rand7());
        System.out.println(random7Generator.rand7());

    }
}
