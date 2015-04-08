package practice.otherProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

 * For example:
 *
 * Given binary tree {3,9,20,#,#,15,7},
 *
 * return its level order traversal as:
 * [ [3], [9,20], [15,7] ]
 *
 * @author Yashraj R. Sontakke
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();

        queue.add(root);


        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> level = new ArrayList<Integer>();
            for(int i=0;i<len;i++){
                TreeNode node = queue.remove(0);
                level.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();

        queue.add(root);
        queue.add(null);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> level = new ArrayList<Integer>();
        while(!queue.isEmpty()){
            TreeNode node = queue.remove(0);
            if(node!=null){
                level.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }else if(queue.isEmpty()){
                result.add(level);
                break;
            }else{
                result.add(level);
                level = new ArrayList<Integer>();
                queue.add(null);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal b = new BinaryTreeLevelOrderTraversal();

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;


        node3.left = node4;
        node3.right = node5;

        System.out.println(b.levelOrder(node1).toString());
        System.out.println(b.levelOrder1(node1).toString());

        node1.left = null;
        System.out.println(b.levelOrder(node1).toString());
        System.out.println(b.levelOrder1(node1).toString());
    }
}
