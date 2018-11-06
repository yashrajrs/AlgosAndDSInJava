//package practice;
//
//import java.math.BigDecimal;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
///**
// * Created by yashraj on 10/23/18.
// */
//public class Lambda {
//
//    public void mapLambda(List<String> list) {
//        List<String> collect = list.stream().filter(x -> !x.equalsIgnoreCase("Two")).map(String::toUpperCase).collect(Collectors.toList());
//        System.out.println(collect.toString());
//
//        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
//        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
//
//        System.out.println("Filtered List: " + filtered);
//        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
//        System.out.println("Merged String: " + mergedString);
//
//        List<Staff> staff = Arrays.asList(
//                new Staff("mkyong", 30, new BigDecimal(10000)),
//                new Staff("jack", 27, new BigDecimal(20000)),
//                new Staff("lawrence", 33, new BigDecimal(30000))
//        );
//        List<String> collect1 = staff.stream().map(x -> x.getName()).collect(Collectors.toList());
//        System.out.println(collect1.toString());
//
////        String nullString = null;
////        String s = Optional.ofNullable(nullString).ifPresent(System.out.print "Yash");
////        System.out.println(s);
////    }
//
//
//
//    public static void main(String[] args) {
//        Lambda lambda = new Lambda();
//        List<String> list = Arrays.asList("One", "Two", "Three");
//        lambda.mapLambda(list);
//    }
//
//    public class Staff {
//
//        private String name;
//
//        public int getAge() {
//            return age;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public BigDecimal getSalary() {
//            return salary;
//        }
//
//        private int age;
//        private BigDecimal salary;
//
//        public Staff(String name, int age, BigDecimal salary) {
//            this.name = name;
//            this.age = age;
//            this.salary = salary;
//        }
//    }
//
//}
