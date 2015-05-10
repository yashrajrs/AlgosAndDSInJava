package practice.otherProblems.trees;

import practice.otherProblems.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * <p/>
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * <p/>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 *
 * @author Yashraj R. Sontakke
 */
public class UniqueBinarySearchTrees2 {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int begin, int end) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (begin > end) {
            result.add(null);
            return result;
        }

        for (int i = begin; i <= end; i++) {
            List<TreeNode> left = generateTrees(begin, i - 1);
            List<TreeNode> right = generateTrees(i + 1, end);
            for (int j = 0; j < left.size(); j++) {
                for (int k = 0; k < right.size(); k++) {
                    TreeNode node = new TreeNode(i);
                    node.left = left.get(j);
                    node.right = right.get(k);
                    result.add(node);
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        UniqueBinarySearchTrees2 u = new UniqueBinarySearchTrees2();
        List<TreeNode> result = u.generateTrees(3);
        for(TreeNode node : result){
            u.inorderTraversal(node);
            System.out.println();
        }
    }

    private  void inorderTraversal(TreeNode node){
        if(node == null){
            return;
        }
        inorderTraversal(node.left);
        System.out.print(node.val +" ");
        inorderTraversal(node.right);
    }
}
