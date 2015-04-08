package practice.otherProblems;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.


 * For example, the following two linked lists:

 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 *
 * Notes:

 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 *
 * @author Yashraj R. Sontakke
 */
public class TwoLinkedListIntersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB =0;
        ListNode a = headA, b = headB;

        while(a != null){
            lenA++;
            a = a.next;
        }

        while(b != null){
            lenB++;
            b = b.next;
        }

        a = headA;
        b = headB;
        int diff;

        if(lenA > lenB){
            diff = lenA - lenB;
            int i = 0;
            while(i < diff){
                a = a.next;
                i++;
            }
        }else if(lenA < lenB){
            diff = lenB - lenA;
            int i = 0;
            while(i < diff){
                b = b.next;
                i++;
            }
        }
        while(a!= null && b !=null){
            if(a.val == b.val){
                return a;
            }else{
                a = a.next;
                b = b.next;
            }
        }
        return null;
    }

    public static void main(String[] args){
        TwoLinkedListIntersection t = new TwoLinkedListIntersection();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);

        ListNode node21 = new ListNode(3);
        ListNode node22 = new ListNode(4);
        ListNode node23 = new ListNode(5);

        ListNode node31 = new ListNode(6);
        ListNode node32 = new ListNode(7);
        ListNode node33 = new ListNode(9);

        node1.next = node2;
        node2.next = node31;

        node21.next = node22;
        node22.next = node23;
        node23.next = node31;

        node31.next = node32;
        node32.next = node33;

        ListNode l = t.getIntersectionNode(node1,node21);
        if(l!=null){
            System.out.println(l.val);
        }else{
            System.out.println(l);
        }

        l = t.getIntersectionNode(node1,node31);
        if(l!=null){
            System.out.println(l.val);
        }else{
            System.out.println(l);
        }

        l = t.getIntersectionNode(node1,node33);
        if(l!=null){
            System.out.println(l.val);
        }else{
            System.out.println(l);
        }

        ListNode node = new ListNode(10);

        l = t.getIntersectionNode(node1,node);
        if(l!=null){
            System.out.println(l.val);
        }else{
            System.out.println(l);
        }
    }
}
