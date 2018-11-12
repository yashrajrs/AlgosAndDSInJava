package practice.problems.strings;

/**
 * Given any integer, print an English phrase that describes the integer (e.g., "One
 * Thousand, Two Hundred Thirty Four").
 *
 * @author Yashraj R. Sontakke
 */
public class NumberToString {

    public String[] digits = {"One", "Two", "Three", "Four", "Five",
            "Six", "Seven", "Eight", "Nine"};
    public String[] teens = {"Eleven", "Twelve", "Thirteen",
            "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
            "Nineteen"};
    public static String[] tens = {"Ten", "Twenty", "Thirty", "Forty",
            "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public static String[] bigs = {"", "Thousand", "Million"};

    public String numToString(Integer number) {
        if (number == 0) {
            return "Zero";
        } else if (number < 0) {
            return "Negative " + numToString(-1 * number);
        }

        int count = 0;
        String str = "";
        while (number > 0) {
            if (number % 1000 != 0) {
                str = numToString100(number % 1000) + bigs[count] + " " + str;

            }
            number /= 1000;
            count++;


        }
        return str;
    }

    public String numToString100(Integer number) {
        String str = "";
        if (number > 100) {
            str = digits[number / 100 - 1] + " Hundred ";
            number %= 100;
        }

        if (number >= 11 && number <= 19) {
            str = str + teens[number - 11] + " ";
        } else if (number == 10 || number >= 20) {
            str = str + tens[number / 10 - 1] + " ";
            number %= 10;
        }
        if (number >= 1 && number <= 9) {
            str = str + digits[number - 1] + " ";
        }
        return str;
    }

    public static void main(String[] args) {
        NumberToString numberToString = new NumberToString();
        System.out.println(numberToString.numToString(1234));
        System.out.println(numberToString.numToString(-12));
        System.out.println(numberToString.numToString(453560));
        System.out.println(numberToString.numToString(1000));
        System.out.println(numberToString.numToString(1234567));

    }

}
