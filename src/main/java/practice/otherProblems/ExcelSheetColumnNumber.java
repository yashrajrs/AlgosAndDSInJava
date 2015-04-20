package practice.otherProblems;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.

 * For example:

 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 *
 * @author Yashraj R. Sontakke
 */
public class ExcelSheetColumnNumber {

    public int titleToNumber1(String s) {
        int p = 0;
        int result = 0;
        for (int i = s.length()-1;i>=0;i--){
            result += Math.pow(26,p) * (s.charAt(i)-'A'+1);
            p++;
        }
        return result;
    }

    public int titleToNumber(String s) {
        int result = 0;
        for (char c : s.toCharArray()){
            result = result*26 + (c-'A'+1);
        }
        return result;
    }

    public static void main(String[] args){
        ExcelSheetColumnNumber e = new ExcelSheetColumnNumber();
        System.out.println(e.titleToNumber("A"));
        System.out.println(e.titleToNumber("Z"));
        System.out.println(e.titleToNumber("AA"));

        System.out.println(e.titleToNumber("AAB"));
        System.out.println(e.titleToNumber1("AAB"));
    }
}
