package practice.otherProblems.string;

/**
 * Created by yashraj on 1/27/19.
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();

        int i=0;
        int j=0;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(i<n1.length() || j <n2.length()) {
            int sum = 0;
            if(i< n1.length()) {
                sum+= n1.charAt(i) - '0';
                i++;
            }
            if(j< n2.length()) {
                sum+= n2.charAt(j) - '0';
                j++;
            }
            sum+=carry;
            if(sum >= 10) {
                carry = sum/10;
                sum%=10;
            } else {
                carry = 0;
            }
            sb.append(sum);
        }
        while (carry > 0) {
            sb.append(carry%10);
            carry/=10;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args){
        AddStrings a  = new AddStrings();
//        System.out.println(a.addStrings("123", "456"));
//        System.out.println(a.addStrings("123", "56"));
        System.out.println(a.addStrings("55", "55"));
    }
}
