package practice.otherProblems.trees;

import practice.otherProblems.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, imagine yourself standing on the left side of it,
 * return the values of the nodes you can see ordered from top to bottom.

 * For example:
 * Given the following binary tree,
 *  --->    1
 *         / \
 *  --->  2  3
 *        \
 *  --->  5
 You should return [5, 3].
 *
 * @author Yashraj R. Sontakke
 */
public class BinaryTreeBottomView {


    public List<Integer> printBottomView(TreeNode node){
        List<Integer> list = new ArrayList<Integer>();
        printBottomView(node, list);
        return list;
    }

    private void printBottomView(TreeNode node, List<Integer> list){
        if (node == null){
            return;
        }
        printBottomView(node.left, list);
        if (node.left == null || node.right == null){
            list.add(node.val);
        }
        printBottomView(node.right, list);
    }


    public static void main(String[] args){
        BinaryTreeBottomView b = new BinaryTreeBottomView();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;

        System.out.println(b.printBottomView(n1));


//                  20
//                /    \
//               8       22
//             /   \      \
//           5      3      25
//                / \
//             10    14

//        You should return [ 5, 10, s14, 25].

        TreeNode n11 = new TreeNode(20);
        TreeNode n12 = new TreeNode(8);
        TreeNode n13 = new TreeNode(22);
        TreeNode n14 = new TreeNode(5);
        TreeNode n15 = new TreeNode(3);
        TreeNode n16 = new TreeNode(25);
        TreeNode n17 = new TreeNode(10);
        TreeNode n18 = new TreeNode(14);

        n11.left = n12;
        n11.right = n13;
        n12.left = n14;
        n12.right = n15;
        n13.right = n16;
        n15.left = n17;
        n15.right = n18;

        System.out.println(b.printBottomView(n11));


    }
}
