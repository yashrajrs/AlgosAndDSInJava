package practice.problems.trees;

import practice.otherProblems.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.

 Two trees are duplicate if they have the same structure with same node values.

 Example 1:

       1
      / \
     2   3
    /   / \
   4   2   4
      /
     4
 The following are two duplicate subtrees:

   2
  /
 4
 and

 4
 Therefore, you need to return above trees' root in the form of a list.
 */
public class FindDuplicateSubTrees {
    Map<String, Integer> count;
    List<TreeNode> ans;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap();
        ans = new ArrayList();
        collect(root);
        return ans;
    }

    public String collect(TreeNode node) {
        if (node == null) {
            return "#";
        }
        String serial = node.val + "," + collect(node.left) + "," + collect(node.right);
        count.put(serial, count.getOrDefault(serial, 0) + 1);
        if (count.get(serial) == 2) {
            ans.add(node);
        }
        return serial;
    }

    public static void main(String[] args) {
        FindDuplicateSubTrees findDuplicateSubTrees = new FindDuplicateSubTrees();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(4);

        node1.left = node2;
        node1.right =node3;

        node2.left = node4;

        node3.left = node5;
        node3.right = node6;

        node5.left = node7;

        System.out.println(findDuplicateSubTrees.findDuplicateSubtrees(node1));
    }
}
