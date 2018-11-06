package practice.careercup;

import practice.problemSolving.string.StringCompress_1_5;

/**
 * Created by yashraj on 7/20/16.
 */
public class MatrixWordCount {

    public int search(char[][] a, int x, int y, int index, String searchString) {
        if (x<0 ||x> a.length -1 || y <0 || y > a[0].length-1) {
            return 0;
        }
        if (index == searchString.length()) {
            return 1;
        }
        int totalCount = 0;
        for (int i=index;i<searchString.length(); i++) {
            if (searchString.charAt(i) == a[x][y]) {
                int leftSearch = search(a, x-1,y,index+1, searchString);
                int rightSearch = search(a, x+1,y,index+1, searchString);
                int topSearch = search(a, x,y-1,index+1, searchString);
                int bottomSearch = search(a, x,y+1,index+1, searchString);
                System.out.println(String.format("%d : %d : %d : %d", leftSearch, rightSearch, topSearch, bottomSearch));
                totalCount += leftSearch + rightSearch + topSearch + bottomSearch;
            }
        }
        return totalCount;
    }

    public int search(char[][] a, String searchString) {
        int totalCount = 0;
        for (int i=0;i<a.length; i++) {
            for (int j=0;j<a[0].length; j++) {
                totalCount += search(a, i, j, 0, searchString);
            }
        }
        return totalCount;
    }

    public static void main(String[] args) {
        MatrixWordCount m = new MatrixWordCount();

        char[][] a = { {'B', 'B', 'A', 'B', 'B', 'N'},
                {'B', 'B', 'M', 'B', 'B', 'O'},
                {'B', 'B', 'A', 'B', 'B', 'Z'},
                {'N', 'O', 'Z', 'A', 'M', 'A'},
                {'B', 'B', 'B', 'B', 'B', 'M'},
                {'B', 'B', 'B', 'B', 'B', 'A'} };
        String search = "AMAZON";

        int count = m.search(a, search);
        System.out.println(count);
    }
}
