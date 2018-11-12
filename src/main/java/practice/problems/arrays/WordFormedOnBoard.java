package practice.problems.arrays;

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Given a 4 X 4 game slot that has random alphabets in all the slots
 * Write a function that takes the keyboard and the word as input and returns true if the word can be formed
 * False otherwise.
 * <p/>
 * A word can be formed on the board by connecting alphabets adjacent to each other (horizontal, vertical and diagonally)
 * Same alphabet should not be reused.
 *
 * @author Yashraj R. Sontakke
 */
public class WordFormedOnBoard {

    Character[][] board = {{'S', 'T', 'F', 'M'}, {'R', 'U', 'N', 'G'}, {'T', 'A', 'M', 'N'}, {'E', 'O', 'N', 'I'}};

    public static Set<ArrayList<Location>> wordLocations = Sets.newHashSet();


    public void getValue(ArrayList<Character> input, ArrayList<Location> currentLocations, Integer wordSize) {
        if (input.isEmpty()) {

            if (isValidWord(currentLocations, wordSize)) {
                wordLocations.add(currentLocations);
            }

            return;
        }

        for (int x = 0; x < input.size(); x++) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (input.get(x) == board[i][j]) {
                        Location location = new Location(i, j);
                        ArrayList<Location> locations = new ArrayList<Location>(currentLocations);
                        locations.add(location);
                        ArrayList<Character> currentInput = new ArrayList<Character>(input.subList(x + 1, input.size()));
                        getValue(currentInput, locations, wordSize);
                    }
                }
            }
        }

    }

    public void canBeFormed(ArrayList<Character> input) {

        for (int x = 0; x < input.size(); x++) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (input.get(x) == board[i][j]) {
                        Location location = new Location(i, j);
                        ArrayList<Location> locations = new ArrayList<Location>();
                        locations.add(location);
                        getValue(new ArrayList<Character>(input.subList(x + 1, input.size())), locations, input.size());
                    }
                }
            }
        }


    }

    public boolean isValidWord(final ArrayList<Location> currentLocations, final Integer wordSize) {
        if (currentLocations.size() != wordSize) {
            return false;
        }
        Location firstLocation = currentLocations.get(0);
        boolean rowCheck = true;
        for (int i = 1; i < currentLocations.size(); i++) {
            if (firstLocation.getRow() != currentLocations.get(i).getRow()) {
                rowCheck = false;
                break;
            }
        }
        if (rowCheck) {
            return true;
        }

        boolean columnCheck = true;
        for (int i = 1; i < currentLocations.size(); i++) {
            if (firstLocation.getColumn() != currentLocations.get(i).getColumn()) {
                columnCheck = false;
                break;
            }
        }
        if (columnCheck) {
            return true;
        }

        boolean diagonalCheck = true;
        int value = Math.abs(firstLocation.getColumn() - firstLocation.getRow());
        for (int i = 1; i < currentLocations.size(); i++) {
            if (value != Math.abs(currentLocations.get(i).getColumn() - currentLocations.get(i).getRow())) {
                diagonalCheck = false;
                break;
            }
        }
        return diagonalCheck;
    }


    public class Location {
        private Integer row;
        private Integer column;

        public Location(final Integer row, final Integer column) {
            this.row = row;
            this.column = column;
        }

        public Integer getRow() {
            return row;
        }

        public Integer getColumn() {
            return column;
        }
    }


    public static void main(String[] args) {
        WordFormedOnBoard wordFormedOnBoard = new WordFormedOnBoard();
//      wordFormedOnBoard.canBeFormed(new ArrayList<Character>(Arrays.asList('T', 'U', 'A', 'O')));
//      wordFormedOnBoard.canBeFormed(new ArrayList<Character>(Arrays.asList('T', 'A', 'M', 'N')));
//      wordFormedOnBoard.canBeFormed(new ArrayList<Character>(Arrays.asList('S', 'U', 'M', 'I')));

//      wordFormedOnBoard.canBeFormed(new ArrayList<Character>(Arrays.asList('T', 'U', 'A', 'M')));
//      wordFormedOnBoard.canBeFormed(new ArrayList<Character>(Arrays.asList('T', 'A', 'M', 'I')));
//      wordFormedOnBoard.canBeFormed(new ArrayList<Character>(Arrays.asList('S', 'U', 'M', 'N')));

        wordFormedOnBoard.canBeFormed(new ArrayList<Character>(Arrays.asList('T', 'U', 'A')));


        if (wordLocations.isEmpty()) {
            System.out.println("Word cannot be formed");
        } else {
            System.out.println("Word can be formed");
        }
        System.out.println(wordFormedOnBoard.canBeFormed1("TUA"));
    }

    public boolean canBeFormed1(String input) {
        for (int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if (board[i][j] == input.charAt(0)) {
                    Location location = new Location(i, j);
                    ArrayList<Location> locations = new ArrayList<>();
                    locations.add(location);
                    return dfs(input, 1, locations, i+1, j) ||
                            dfs(input, 1, locations, i-1, j) ||
                            dfs(input, 1, locations, i, j+1) ||
                            dfs(input, 1, locations, i, j-1) ||
                            dfs(input, 1, locations, i-1, j-1) ||
                            dfs(input, 1, locations, i+1, j+1);
                }
            }
        }
        return false;
    }

    public boolean dfs(String input, int count, ArrayList<Location> locations, int i, int j) {
        if (count == input.length() && isValidWord(locations, input.length())) {
            return true;
        }
        int m = board.length;
        int n = board[0].length;
        if (i< 0 || i>m || j<0 || j> n || board[i][j] != input.charAt(count)) {
            return false;
        }
        locations.add(new Location(i, j));
        return dfs(input, count+1, locations, i+1, j) ||
                dfs(input, count+1, locations, i-1, j) ||
                dfs(input, count+1, locations, i, j+1) ||
                dfs(input, count+1, locations, i, j-1) ||
                dfs(input, count+1, locations, i-1, j-1) ||
                dfs(input, count+1, locations, i+1, j+1);
    }
}
