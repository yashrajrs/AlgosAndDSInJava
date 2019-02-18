package practice.otherProblems.trees;

import practice.otherProblems.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.



 Example:

 Input: [1,2,3,4,5]

     1
    / \
   2   3
  / \
 4   5

 Output: [[4,5,3],[2],[1]]


 Explanation:

 1. Removing the leaves [4,5,3] would result in this tree:

   1
  /
 2


 2. Now removing the leaf [2] would result in this tree:

 1


 3. Now removing the leaf [1] would result in the empty tree:

 []

 */
public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        findLeaves(root, 0, result);
        return result;
    }

    public int findLeaves(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) {
            return  0;
        }
        if (root.left == null && root.right == null) {
            if (result.size() == level) {
                result.add(new ArrayList<>());
            }
            result.get(level).add(root.val);
            return level;
        }
        int leftLevel = findLeaves(root.left, level, result);
        int rightLevel = findLeaves(root.right, level, result);
        int currentLevel = Math.max(leftLevel, rightLevel) + 1;
        if (result.size() == currentLevel) {
            result.add(new ArrayList<>());
        }
        result.get(currentLevel).add(root.val);
        return currentLevel;
    }

    public static void main(String[] args){
        FindLeavesOfBinaryTree f = new FindLeavesOfBinaryTree();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        System.out.println(f.findLeaves(n1));
    }

}
