package practice.otherProblems;

/**
 * Description:

 * Count the number of prime numbers less than a non-negative number, n
 *
 * @author Yashraj R. Sontakke
 */
public class CountPrimes {

    public int countPrimes(int n) {
        if(n <= 2){
            return 0;
        }
        int upperBound = (int) Math.sqrt(n-1);
        boolean[] isComposite = new boolean[n];
        for(int i=2;i<= upperBound;i++){
            if(!isComposite[i]){
                for(int k= i+i;k<n;k+=i){
                    isComposite[k] =true;
                }
            }
        }
        int count = 0;
        for(int i=2;i<n;i++){
            if(!isComposite[i]){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        CountPrimes c = new CountPrimes();
        System.out.println(c.countPrimes(7));
    }
}



