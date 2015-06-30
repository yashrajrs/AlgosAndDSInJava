package practice.problems.arrays;

import com.google.common.collect.Sets;

import java.util.*;

/**
 * Finds the length of the largest increasing sub sequence of the input list provided
 *
 * @author Yashraj R. Sontakke
 */
public class LongestIncreasingSubSequence {


    public static Set<ArrayList<Integer>> sequences = Sets.newHashSet();


    public void subSequences(ArrayList<Integer> input, ArrayList<Integer> currentSequence) {

        if (input.isEmpty()) {
            sequences.add(currentSequence);
            return;
        }


        for (int i = 0; i < input.size(); i++) {
            ArrayList<Integer> currentInput = new ArrayList<Integer>(input.subList(i + 1, input.size()));
            if (currentSequence.get(currentSequence.size() - 1) < input.get(i)) {
                ArrayList<Integer> tempCurrentSequence = new ArrayList<Integer>(currentSequence);
                tempCurrentSequence.add(input.get(i));
                subSequences(currentInput, tempCurrentSequence);
            } else {
                subSequences(currentInput, currentSequence);
            }

        }
        sequences.add(currentSequence);
    }

    public void findSubSequences(ArrayList<Integer> input) {
        for (int i = 0; i < input.size(); i++) {
            ArrayList<Integer> currentInput = new ArrayList<Integer>(input.subList(i + 1, input.size()));
            subSequences(currentInput, new ArrayList<Integer>(Arrays.asList(input.get(i))));
        }
    }



    public void getSubSequences(ArrayList<Integer> input, ArrayList<Integer> currentSubSequence, Set<ArrayList<Integer>> subSequences){
        if (input.isEmpty()){
            subSequences.add(currentSubSequence);
            return;
        }

        for (int i=0;i<input.size();i++){
            ArrayList<Integer> newInput = new ArrayList<Integer>(input.subList(i+1,input.size()));
            if (currentSubSequence.isEmpty() || currentSubSequence.get(currentSubSequence.size()-1) < input.get(i)){
                ArrayList<Integer> newCurrentSubSequence = new ArrayList<Integer>(currentSubSequence);
                newCurrentSubSequence.add(input.get(i));
                getSubSequences(newInput,newCurrentSubSequence,subSequences);
            }else{
                getSubSequences(newInput,currentSubSequence,subSequences);
            }
        }
    }



    public void findSub1(ArrayList<Integer> input){
        ArrayList<Integer> current = new ArrayList<Integer>();
        HashMap<Integer, Set<ArrayList<Integer>>> result = new HashMap<Integer, Set<ArrayList<Integer>>>();
        findSub1(input,0, 0, current, result);

        int max = Collections.max(result.keySet());
        System.out.println(result.get(max));
    }


    public void findSub1(ArrayList<Integer> input, int index, int lastVal, ArrayList<Integer> current,
                         HashMap<Integer, Set<ArrayList<Integer>>> result){
        if (index == input.size()){
            if (result.containsKey(current.size())){
                    Set<ArrayList<Integer>> list = result.get(current.size());
                    list.add(new ArrayList<Integer>(current));
                    result.put(current.size(), list);
            }else{
                Set<ArrayList<Integer>> list = new HashSet<ArrayList<Integer>>();
                list.add(new ArrayList<Integer>(current));
                result.put(current.size(), list);
            }
            return;
        }
        for (int i=index;i<input.size();i++){
            if (input.get(i) > lastVal){
                current.add(input.get(i));
                findSub1(input, i+1, input.get(i), current, result);
                current.remove(current.size()-1);
            }else{
                findSub1(input, i+1, lastVal, current, result);
            }
        }
    }

    public static void main(String[] args) {
        LongestIncreasingSubSequence longestIncreasingSubsequence = new LongestIncreasingSubSequence();
//        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15));
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(10,22,9,33,21,50,41,60,80));
        longestIncreasingSubsequence.findSubSequences(input);
        ArrayList<Integer> largestSequence = new ArrayList<Integer>();

        for (ArrayList<Integer> list : longestIncreasingSubsequence.sequences) {

            if (largestSequence.size() < list.size()) {
                largestSequence = list;
            }
        }
        System.out.println(String.format("Largest increasing subSequence is %s of size %d", largestSequence.toString(), largestSequence.size()));


        System.out.println();

        longestIncreasingSubsequence.findSub1(new ArrayList<Integer>(input));

        Set<ArrayList<Integer>> subSeq = Sets.newHashSet();
        longestIncreasingSubsequence.getSubSequences(input, new ArrayList<Integer>(), subSeq);
        largestSequence = new ArrayList<Integer>();

        for (ArrayList<Integer> list : subSeq){
            if (largestSequence.size() < list.size()){
                largestSequence = list;
            }
        }

        System.out.println(String.format("Largest increasing subSequence is %s of size %d", largestSequence.toString(), largestSequence.size()));


        List<Integer> list = Arrays.asList(10,22,9,33,21,50,41,60,80);
        Integer[] array = new Integer[list.size()];
        longestIncreasingSubsequence.longestsub(input, 0, array,0);
    }

    private static int maxLength = 0;

    private void longestsub(List<Integer> input, int pos, Integer[] array, int arrayPos){
//        System.out.println(Arrays.asList(array).toString());
        if (pos== input.size()){
            if (maxLength < arrayPos){
                System.out.println(Arrays.asList(array).subList(0, arrayPos));
                maxLength = arrayPos;
            }
            return;
        }

        for (int i=pos;i<input.size();i++){
            if (arrayPos == 0 || array[arrayPos-1] < input.get(pos)){
                array[arrayPos] = input.get(i);

                longestsub(input, i+1, array, arrayPos+1);
                array[arrayPos] = null;
            }
        }
//        System.out.println(Arrays.asList(array).subList(0, arrayPos));
    }
}
