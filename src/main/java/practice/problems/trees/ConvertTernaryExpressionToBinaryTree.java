package practice.problems.trees;

import practice.dataStructures.trees.TreeNode;

import java.util.Stack;

/**
 * Given a string that contains ternary expressions. The expressions may be nested, task is convert the given ternary expression to a binary Tree.

 Examples:

 Input :  string expression =   1?2:3
 Output :         1
                 /  \
                2    3

 Input : expression =  1?2?3:4:5
 Output :     1
             /  \
             2    5
            /  \
          3    4
 */
public class ConvertTernaryExpressionToBinaryTree {


    class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        TreeNode(char val) {
            this.val = val;
        }
    }


    public TreeNode convert(String input) {
       if (input == null) {
           return null;
       }
        TreeNode root = new TreeNode(input.charAt(0));
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        for (int i=1;i<input.length();i++) {
            if (input.charAt(i) == '?') {
                TreeNode node = stack.peek();
                node.left = new TreeNode(input.charAt(i+1));
                stack.push(node.left);
            } else if (input.charAt(i) == ':') {
                stack.pop();
                TreeNode node = stack.pop();
                node.right = new TreeNode(input.charAt(i+1));
                stack.push(node.right);
            }
        }
        return root;
    }


    public static void main(String[] args) {
        ConvertTernaryExpressionToBinaryTree convertTernaryExpressionToBinaryTree = new ConvertTernaryExpressionToBinaryTree();
        String input1 = "1?2:3";
        TreeNode output1 = convertTernaryExpressionToBinaryTree.convert(input1);
        convertTernaryExpressionToBinaryTree.printInOrder(output1);

        System.out.println();

        String input2 = "1?2?3:4:5";
        TreeNode output2 = convertTernaryExpressionToBinaryTree.convert(input2);
        convertTernaryExpressionToBinaryTree.printInOrder(output2);
    }


    public void printInOrder(final TreeNode node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.val + " ");
            printInOrder(node.right);
        }
    }
}
