package practice.problems.arrays;

/**
 * Remove duplicates from an array.
 *
 * @author Yashraj R. Sontakke
 */
public class ArrayRemoveDuplicates {

    public void removeDuplicates(int[] array) {
        int i = 0;
        int arrayEnd = array.length - 1;

        while (i <= arrayEnd) {
            int current = array[i];
            int j = i + 1;
            while (j <= arrayEnd) {
                if (current == array[j]) {
                    moveElements(array, j, arrayEnd);
                    arrayEnd--;
                }
                j++;
            }
            i++;
        }


        for (int k = 0; k <= arrayEnd; k++) {
            System.out.print(array[k] + " ");
        }
    }

    public void moveElements(int[] array, int start, int end) {
        for (int i = start; i < end; i++) {
            array[i] = array[i + 1];
        }
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 4, 5, 2, 3, 5, 9, 9};
        ArrayRemoveDuplicates arrayRemoveDuplicates = new ArrayRemoveDuplicates();
        arrayRemoveDuplicates.removeDuplicates(input);
    }
}
