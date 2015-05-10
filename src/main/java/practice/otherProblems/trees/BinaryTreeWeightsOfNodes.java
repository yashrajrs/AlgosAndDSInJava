package practice.otherProblems.trees;

import practice.otherProblems.TreeNode ;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the weights of all nodes of a tree.
 * Where weight of a node is left subtree weight + right subtree weight + node value.
 *
 * @author Yashraj R. Sontakke
 */
public class BinaryTreeWeightsOfNodes {

    public Map<TreeNode, Integer> getWeights(TreeNode root){
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        getWeights(root, map);
        return map;
    }

    private Integer getWeights(TreeNode node, Map<TreeNode, Integer> map){
        if (node == null){
            return 0;
        }
        Integer leftHeight = getWeights(node.left, map);
        Integer rightHeight = getWeights(node.right, map);

        Integer height = leftHeight + rightHeight + node.val;
        map.put(node, height);
        return height;
    }


    public static void main(String[] args){
        BinaryTreeWeightsOfNodes w = new BinaryTreeWeightsOfNodes();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

//          1
//         / \
//         2  3
//        / \ / \
//        4 5 6 7

        System.out.println(w.getWeights(node1).toString());

        node2.left = null;
        node3.right = null;

//          1
//         / \
//         2  3
//         \ /
//         5 6

        System.out.println(w.getWeights(node1).toString());
    }
}
