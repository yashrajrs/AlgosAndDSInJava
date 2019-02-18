package practice.otherProblems.trees;

import practice.otherProblems.TreeNode;

import java.util.*;

/**
 Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

 If two nodes are in the same row and column, the order should be from left to right.

 Examples 1:

 Input: [3,9,20,null,null,15,7]

 3
 /\
 /  \
 9  20
 /\
 /  \
 15   7

 Output:

 [
 [9],
 [3,15],
 [20],
 [7]
 ]
 Examples 2:

 Input: [3,9,8,4,0,1,7]

 3
 /\
 /  \
 9   8
 /\  /\
 /  \/  \
 4  01   7

 Output:

 [
 [4],
 [9],
 [3,0,1],
 [8],
 [7]
 ]
 Examples 3:

 Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)

 3
 /\
 /  \
 9   8
 /\  /\
 /  \/  \
 4  01   7
 /\
 /  \
 5   2

 Output:

 [
 [4],
 [9,5],
 [3,0,1],
 [8,2],
 [7]
 ]
 */
public class BinaryTreeVerticalOrderTraversal {
    //Works
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> level = new LinkedList<>();

        queue.offer(root);
        level.offer(0);

        int minLevel = 0;
        int maxLevel = 0;

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Integer l = level.poll();

            minLevel = Math.min(minLevel, l);
            maxLevel = Math.max(maxLevel, l);

            if(map.containsKey(l)) {
                map.get(l).add(node.val);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(node.val);
                map.put(l, list);
            }

            if (node.left != null) {
                queue.offer(node.left);
                level.offer(l - 1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                level.offer(l+1);
            }
        }

        for (int i=minLevel;i<=maxLevel;i++) {
            if (map.containsKey(i)) {
                result.add(map.get(i));
            }
        }
        return result;
    }
}
