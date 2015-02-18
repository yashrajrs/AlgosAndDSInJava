package practice.problemSolving;

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

/**
 * A circus is designing a tower routine consisting of people standing atop one another's
 * shoulders. For practical and aesthetic reasons, each person must be both shorter
 * and lighter than the person below him or her. Given the heights and weights of
 * each person in the circus, write a method to compute the largest possible number
 * of people in such a tower
 *
 * EXAMPLE:
 * Input (ht,wt): (65, 100) (70, 150) (56, 90) (75, 190) (60, 95)
 * (68, 110)
 * Output:The longest tower is length 6 and includes from top to bottom:
 * (56, 90) (60,95) (65,100) (68,110) (70,150) (75,190)
 *
 * @author Yashraj R. Sontakke
 */
public class HeightWeightIncreasingSubSequence_11_7 {

    public Set<ArrayList<HeightWeightPair>> sequences = Sets.newHashSet();


    public void getSequences(ArrayList<HeightWeightPair> input, ArrayList<HeightWeightPair> currentSequence){
        if (input.isEmpty()){
            sequences.add(currentSequence);
            return;
        }

        for (int i=0;i<input.size();i++){
            ArrayList<HeightWeightPair> currentInput = new ArrayList<HeightWeightPair>(input.subList(i + 1, input.size()));
            HeightWeightPair inputHeightWeightPair = input.get(i);
            HeightWeightPair lastHeightWeightPair = currentSequence.get(currentSequence.size() - 1);
            if (lastHeightWeightPair.getHeight() < inputHeightWeightPair.getHeight() && lastHeightWeightPair.getWeight() < inputHeightWeightPair.getWeight() ){
                ArrayList<HeightWeightPair> tempCurrentSequence = new ArrayList<HeightWeightPair>(currentSequence);
                tempCurrentSequence.add(inputHeightWeightPair);
                getSequences(currentInput, tempCurrentSequence);
            }else{
                getSequences(currentInput,currentSequence);
            }
        }
        sequences.add(currentSequence);
    }

    public void getSequences(ArrayList<HeightWeightPair> input) {
        Collections.sort(input, new HeightWeightPairComparator());
        for (int i = 0; i < input.size(); i++) {
            ArrayList<HeightWeightPair> currentInput = new ArrayList<HeightWeightPair>(input.subList(i + 1, input.size()));
            getSequences(currentInput, new ArrayList<HeightWeightPair>(Arrays.asList(input.get(i))));
        }

    }


    public static void main(String[] args) {
        HeightWeightIncreasingSubSequence_11_7 longestIncreasingSubsequence = new HeightWeightIncreasingSubSequence_11_7();
        //(65, 100) (70, 150) (56, 90) (75, 190) (60, 95), (68, 110)
        ArrayList<HeightWeightPair> input = new ArrayList<HeightWeightPair>(Arrays.asList(new HeightWeightPair(65,100),
                new HeightWeightPair(70,150),
                new HeightWeightPair(56,90),
                new HeightWeightPair(75,190),
                new HeightWeightPair(60,95),
                new HeightWeightPair(68,110)));
        longestIncreasingSubsequence.getSequences(input);
        ArrayList<HeightWeightPair> largestSequence = new ArrayList<HeightWeightPair>();

        for (ArrayList<HeightWeightPair> list : longestIncreasingSubsequence.sequences) {

            if (largestSequence.size() < list.size()) {
                largestSequence = list;
            }
        }
        System.out.println(String.format("Largest increasing subSequence is %s of size %d", largestSequence.toString(), largestSequence.size()));
    }
}
