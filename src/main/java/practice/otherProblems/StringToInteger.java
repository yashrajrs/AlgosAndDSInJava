package practice.otherProblems;

/**
 * Created with IntelliJ IDEA.
 * User: yashrajsontakke
 * Date: 4/4/15
 * Time: 3:29 PM
 * To change this template use File | Settings | File Templates.
 *
 * @author Yashraj R. Sontakke
 */
public class StringToInteger {
    public int atoi(String str) {
        if (str == null || str.length()<1){
            return 0;
        }

        str = str.trim();
        boolean negative = false;
        int i=0;
        if (str.charAt(0) == '-'){
            negative = true;
            i++;
        }else if (str.charAt(0) == '+'){
            i++;
        }

        double output = 0;
        while (i<str.length() && str.charAt(i) >='0' && str.charAt(i) <='9'){
           output = output *10 + (str.charAt(i) -'0');
            i++;
        }
        if(negative){
           output = -output;
        }
        if (output > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if (output<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int) output;
    }
}
