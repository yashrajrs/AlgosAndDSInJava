package practice.problems;

/**
 * Write a method to shuffle a deck of cards. It must be a perfect shuffle—in other
 * words, each of the 52! permutations of the deck has to be equally likely. Assume that
 * you are given a random number generator which is perfect
 *
 * @author Yashraj R. Sontakke
 */
public class ShuffleCards {

    public int rand(int lower, int higher){
        return lower + (int) (Math.random() * (higher - lower +1));
    }

    public void shuffle(int[] cards){
        for (int i=0;i<cards.length;i++){
            int k = rand(0,i);
            int temp = cards[k];
            cards[k] = cards[i];
            cards[i] = temp;
        }
    }

    public int[] shuffleRecursively(int[] cards ,int i){
        if (i==0){
            return cards;
        }

        shuffleRecursively(cards, i-1);
        int k = rand(0,i);
        int temp = cards[k];
        cards[k] = cards[i];
        cards[i] = temp;

        return cards;
    }

    public static void main(String[] args){
        ShuffleCards shuffleCards = new ShuffleCards();
        int[] input = {9,8,7,6,5,4,3,2,1};
        shuffleCards.shuffle(input);
        for (int i=0;i<input.length;i++){
            System.out.print(input[i] + " ");
        }
        System.out.println();
        int[] input1 = {9,8,7,6,5,4,3,2,1};
        int[] output = shuffleCards.shuffleRecursively(input1, input1.length-1);
        for (int i=0;i<output.length;i++){
            System.out.print(output[i] + " ");
        }
    }
}
