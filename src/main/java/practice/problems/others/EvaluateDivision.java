//package practice.problems.others;
//
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//
///**
// * Created by yashraj on 2/6/19.
// */
//public class EvaluateDivision {
//    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
//        Map<String, Double> hashMap = new HashMap<>();
//        Set<String> variables = new HashSet<>();
//        int i=0;
//        while(i<values.length) {
//            String temp = String.format("%s/%s", equations[i][0], equations[i][1]);
//            hashMap.put(temp, values[i]);
//            variables.add(equations[i][0]);
//            variables.add(equations[i][1]);
//        }
//    }
//
//    public static void main(String[] args){
//
//    }
//}
