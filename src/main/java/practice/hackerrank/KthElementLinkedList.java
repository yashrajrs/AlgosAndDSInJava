package practice.hackerrank;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: yashrajsontakke
 * Date: 5/14/15
 * Time: 8:21 PM
 * To change this template use File | Settings | File Templates.
 *
 * @author Yashraj R. Sontakke
 */
public class KthElementLinkedList {

    public static void kthElement(Long k, Node list){
        Node node = list;
        if (node == null){
            return;
        }
        Node fastNode = node;
        for(int i=0;i<k;i++){
            if (fastNode == null){
                System.out.println("NIL");
                return;
            }
            fastNode = fastNode.getNext();
        }
        if (fastNode == null){
            System.out.println("NIL");
            return;
        }
        Node kthNode = list;
        while (fastNode != null){
            fastNode = fastNode.getNext();
            kthNode = kthNode.getNext();
        }
        System.out.println(kthNode.getVal());
    }


    private void kElement(Long k, Node list){
        Node n = list;
        if (n == null){
            return;
        }
        Node fastNode = n;
        for(int i=0;i<k;i++){
            if (fastNode == null){
                return;
            }
            fastNode = fastNode.getNext();
        }
        if (fastNode == null){
            return;
        }
        Node kth = n;
        while (fastNode!=null){
            fastNode = fastNode.getNext();
            kth = kth.getNext();
        }
        System.out.println(kth.getVal());
    }

    public static class List{
        private Node first, last;

        public void addData(String val){
            if (first == null){
                first = new Node(val);
                last = first;
            }else{
                last.setNext(new Node(val));
                last = last.getNext();
            }
        }
    }

    public static class Node{
        private String val;
        private Node next;

        public Node(String val){
            this.val = val;
        }

        public String getVal() {
            return val;
        }

        public void setVal(String val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String _a;
        _a = in.nextLine();
        String _b;
        _b = in.nextLine();
        List list = new List();
        for (String string : _b.split(" ")){
            list.addData(string);
        }

        kthElement(Long.parseLong(_a), list.first);
    }
}
