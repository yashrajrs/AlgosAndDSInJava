package practice.otherProblems;

import java.util.HashMap;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

 * If the fractional part is repeating, enclose the repeating part in parentheses.

 * For example,

 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 *
 * @author Yashraj R. Sontakke
 */
public class FractionToRecurringDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0){
            return "0";
        }
        if(denominator == 0){
            return "";
        }
        String result ="";

        if((numerator < 0) ^ (denominator < 0)){
            result += "-";
        }
        long num = numerator;
        long denom = denominator;
        num = Math.abs(num);
        denom = Math.abs(denom);

        long res = num / denom;
        result += String.valueOf(res);

        long remainder = (num % denom) * 10;
        if(remainder == 0){
            return result;
        }

        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        result += ".";
        while(remainder != 0){

            if(map.containsKey(remainder)){
                int beg = map.get(remainder);
                String part1 = result.substring(0, beg);
                String part2 = result.substring(beg, result.length());
                result = part1 + "(" + part2 + ")";
                return result;
            }

            map.put(remainder, result.length());
            res = remainder / denom;
            result += String.valueOf(res);
            remainder = (remainder % denom) * 10;
        }
        return result;
    }

    public static void main(String[] args){
        FractionToRecurringDecimal f = new FractionToRecurringDecimal();
        System.out.println(f.fractionToDecimal(1,2));
        System.out.println(f.fractionToDecimal(2,1));
        System.out.println(f.fractionToDecimal(2,3));
    }
}
