package practice.problems;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Display an integer array of [1, 2, 3, 4, 5, 6, 7] in the following format
 * <p/>
 * 1 4 6
 * 2 5 7
 * 3 .
 *
 * @author Yashraj R. Sontakke
 */
public class ArrayDisplayFormat {

    public void printStyle(ArrayList<Integer> input, int noOfColumns) {
        int numbersOnLastRow = input.size() % noOfColumns;
        int noOfRows = input.size() / noOfColumns;
        if (numbersOnLastRow > 0) {
            noOfRows++;
        }

        int[][] matrix = new int[noOfRows][noOfColumns];
        int arrIndex = 0;
        for (int i = 0; i < noOfColumns; i++) {
            for (int j = 0; j < noOfRows; j++) {
                if (j == noOfRows - 1 && i >= numbersOnLastRow) {
                    continue;
                }
                matrix[j][i] = input.get(arrIndex);
                arrIndex++;
                if (arrIndex > input.size()) {
                    break;
                }
            }
        }

        arrIndex = 0;
        for (int i = 0; i < noOfRows; i++) {
            for (int j = 0; j < noOfColumns; j++) {
                if (matrix[i][j] > 0) {
                    System.out.print(String.format("%3d", matrix[i][j]));
                }

                arrIndex++;
                if (arrIndex > input.size()) {
                    break;
                }

            }
            System.out.println();
        }


    }


    public static void main(String[] args) {
        ArrayDisplayFormat arrayDisplayFormat = new ArrayDisplayFormat();
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        arrayDisplayFormat.printStyle(input, 3);
    }
}
