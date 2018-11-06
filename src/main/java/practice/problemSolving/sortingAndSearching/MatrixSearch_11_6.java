package practice.problemSolving.sortingAndSearching;

/**
 * Given an M x N matrix in which each row and each column is sorted in ascending
 * order, write a method to find an element.
 *
 * @author Yashraj R. Sontakke
 */
public class MatrixSearch_11_6 {

    public boolean search(int[][] matrix,int x){
        int row =0;
        int col = matrix[0].length-1;
        while (row<=matrix.length-1 &&col>=0){
            if (matrix[row][col]==x){
                return true;
            }else if (matrix[row][col] > x){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length-1;
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args){
        MatrixSearch_11_6 matrixSearch = new MatrixSearch_11_6();
        int[][] input = {{15,20,40,85},{20,35,80,95},{30,55,95,105},{40,80,100,120}};

        System.out.println(matrixSearch.search(input,55));
        System.out.println(matrixSearch.search(input,12));

        System.out.println(matrixSearch.searchMatrix(input,55));
        System.out.println(matrixSearch.searchMatrix(input,12));
    }
}
