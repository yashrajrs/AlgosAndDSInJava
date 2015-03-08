package practice.problemSolving.recursion;

import java.util.ArrayList;

/**
 * Find ways to place n queens on a board.
 *
 * @author Yashraj R. Sontakke
 */
public class NQueens_9_9 {

    static final Integer GRID_SIZE = 8;


    public void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {
        if (row == GRID_SIZE) {
            results.add(columns.clone());
        } else {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (checkValid(columns, row, col)) {
                    columns[row] = col;
                    placeQueens(row + 1, columns, results);
                }
            }
        }
    }

    public boolean checkValid(Integer[] columns, int row1, int column1) {
        for (int row2 = 0; row2 < row1; row2++) {
            int column2 = columns[row2];

            if (column2 == column1) {
                return false;
            }

            int columnDistance = Math.abs(column2 - column1);

            int rowDistance = row1 - row2;
            if (rowDistance == columnDistance) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueens_9_9 nQueens = new NQueens_9_9();
        Integer[] columns = new Integer[8];
        ArrayList<Integer[]> results = new ArrayList<Integer[]>();
        nQueens.placeQueens(0, columns, results);

        System.out.println(results);
    }
}
