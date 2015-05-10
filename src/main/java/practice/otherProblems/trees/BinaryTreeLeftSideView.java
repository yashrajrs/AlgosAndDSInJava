package practice.otherProblems.trees;

import practice.otherProblems.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  * Given a binary tree, imagine yourself standing on the left side of it,
 * return the values of the nodes you can see ordered from top to bottom.

 * For example:
 * Given the following binary tree,
 *  --->    1
 *         / \
 *  --->  2  3
 *        \  \
 *  --->  5  4
 You should return [1, 2, 5].
 *
 * @author Yashraj R. Sontakke
 */
public class BinaryTreeLeftSideView {

    public List<Integer> getLeftView(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                TreeNode node = queue.remove();
                if (i == 0){
                    result.add(node.val);
                }
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        BinaryTreeLeftSideView b = new BinaryTreeLeftSideView();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n2.right = n5;
        n3.right = n4;

        System.out.println(b.getLeftView(n1));


        TreeNode n21 = new TreeNode(1);
        TreeNode n22 = new TreeNode(2);
        TreeNode n23 = new TreeNode(3);
        TreeNode n25 = new TreeNode(5);

        n21.left = n22;
        n21.right = n23;
        n22.right = n25;

        System.out.println(b.getLeftView(n21));

    }
}
