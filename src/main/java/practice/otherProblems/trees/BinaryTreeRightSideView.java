package practice.otherProblems.trees;

import practice.otherProblems.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.

 * For example:
 * Given the following binary tree,
 *  1            <---
 * / \
 * 2 3         <---
 * \  \
 * 5  4       <---
 You should return [1, 3, 4].
 *
 * @author Yashraj R. Sontakke
 */
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(queue.size() > 0){
            int size = queue.size();
            for(int i=0;i < size;i++){
                TreeNode top = queue.remove();
                if(i == 0){
                    result.add(top.val);
                }
                if(top.right != null){
                    queue.add(top.right);
                }
                if(top.left != null){
                    queue.add(top.left);
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        BinaryTreeRightSideView b = new BinaryTreeRightSideView();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n2.right = n5;
        n3.right = n4;

       System.out.println(b.rightSideView(n1));


        TreeNode n21 = new TreeNode(1);
        TreeNode n22 = new TreeNode(2);
        TreeNode n23 = new TreeNode(3);
        TreeNode n25 = new TreeNode(5);

        n21.left = n22;
        n21.right = n23;
        n22.right = n25;

        System.out.println(b.rightSideView(n21));

    }
}
