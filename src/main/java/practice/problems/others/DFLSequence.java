package practice.problems.others;

/**
 * Created with IntelliJ IDEA.
 * User: yashrajsontakke
 * Date: 4/5/15
 * Time: 3:53 PM
 * To change this template use File | Settings | File Templates.
 *
 * @author Yashraj R. Sontakke
 */
public class DFLSequence {

    public void getSeq(int ones, int twos, int threes, int fours){
        int numSeq = getNumSeq(ones,twos,threes,fours,0);
        System.out.println("numSeq " + numSeq);
    }

    public int getNumSeq(int ones, int twos, int threes,int fours, int last){
        if (ones==0&&twos==0&&threes==0&&fours==0){
            return 1;
        }
        int oneSeq = 0;
        int twoSeq = 0;
        int threeSeq = 0;
        int fourSeq = 0;

        if (last!=1 && ones !=0){
            oneSeq = getNumSeq(ones - 1, twos, threes, fours, 1);
        }
        if (last!=2 && twos!=0){
            twoSeq = getNumSeq(ones,twos-1,threes,fours,2);
        }
        if (last!=3 && threes!=0){
            threeSeq = getNumSeq(ones,twos,threes-1,fours,3);
        }
        if (last!=4 && fours!=0){
            fourSeq = getNumSeq(ones,twos,threes,fours-1,4);
        }
        int res = oneSeq+twoSeq+threeSeq+fourSeq;
        System.out.println("Res " +res);
        return res;

    }

    public static void main(String[] args){
        DFLSequence d = new DFLSequence();

        d.getSeq(4,1,1,1);
    }
}
