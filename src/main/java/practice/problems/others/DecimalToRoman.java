package practice.problems.others;

/**
 * Created with IntelliJ IDEA.
 * User: yashrajsontakke
 * Date: 3/28/15
 * Time: 11:06 AM
 * To change this template use File | Settings | File Templates.
 *
 * @author Yashraj R. Sontakke
 */
public class DecimalToRoman {

    String[] roman ={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    int[] decimal ={1000,900,500,400,100,90,50,40,10,9,5,4,1};

    public void getNum(int num){
        String output="";
        if (num>=0 && num<=4000){
            for (int i=0;i<13;i++){
                while (num>=decimal[i]){
                    num = num- decimal[i];
                    output = output + roman[i];
                }
            }
        }else{
            throw new IllegalStateException("Invalid input");
        }

        System.out.println(output);
    }

//    String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    int[] number = {1000,900,500,400,100,90,50,40,10,9,5,4,1};


    public String intToRoman(int num) {
        String output = "";
        for(int i=0;i<13;i++){
            while(num>= number[i]){
                num = num - number[i];
                output = output + roman[i];
            }
        }
        return output;
    }

    public static void main(String[] args){
        DecimalToRoman decimalToRoman = new DecimalToRoman();
        decimalToRoman.getNum(863);
        System.out.println(decimalToRoman.intToRoman(863));
    }
}
