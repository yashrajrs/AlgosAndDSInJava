package practice.otherProblems;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)

 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:

 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 *
 * @author Yashraj R. Sontakke
 */
public class ZigZagConversion {

    public String convert(String s, int nRows) {
        if (nRows == 1){
            return s;
        }
        char[] array = s.toCharArray();
        int noOfElementsLastRow = s.length()%nRows;
        int noOfCols = s.length()%3;
        if (noOfElementsLastRow > 0){
            noOfCols++;
        }

        Character[][] matrix = new Character[nRows][2*noOfCols];
        int arrIndex = 0;
        for (int j=0;j<2*noOfCols;j++){
            if (arrIndex > array.length-1) {
                break;
            }
            for (int i=0;i<nRows;i++){
                if (arrIndex == 10){
                    System.out.println();
                }
                if (j%2!=0 && i!=1){
                    continue;
                }
                matrix[i][j] = array[arrIndex];
                arrIndex++;
                if (arrIndex>array.length-1){
                    break;
                }
            }
        }
        String output = "";
        for (int i=0;i<nRows;i++){
            for (int j=0;j<2*noOfCols;j++){
                if (matrix[i][j] != null ){
                    output = output + matrix[i][j];
                }
            }
        }
        return output;
    }

    public static void main(String[] args){
        ZigZagConversion z = new ZigZagConversion();
        System.out.println(z.convert("PAYPALISHIRING",3));
        System.out.println(z.convert("ABC",1));
        new PriorityQueue<Integer>(Collections.reverseOrder());
    }
}
