package practice.otherProblems;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 * For example:

 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 *
 * @author Yashraj R. Sontakke
 */
public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n>0){
            n--;
            char c = (char) (n%26 + 'A');
            sb.append(c);
            n/=26;
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args){
        ExcelSheetColumnTitle e = new ExcelSheetColumnTitle();
        System.out.println(e.convertToTitle(1));
        System.out.println(e.convertToTitle(3));
        System.out.println(e.convertToTitle(26));
        System.out.println(e.convertToTitle(27));
    }
}
