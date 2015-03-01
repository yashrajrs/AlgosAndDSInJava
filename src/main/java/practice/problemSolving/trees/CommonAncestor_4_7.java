package practice.problemSolving.trees;

import practice.dataStructures.trees.TreeNode;

/**
 * Design an algorithm and write code to find the first common ancestor of two nodes
 * in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
 * necessarily a binary search tree.
 *
 * @author Yashraj R. Sontakke
 */
public class CommonAncestor_4_7 {

    public static class Result{
        public TreeNode node;
        public boolean isAncestor;

        public Result(TreeNode n, boolean isAnc){
            node = n;
            isAncestor = isAnc;
        }
    }

    public Result findCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root == null){
            return null;
        }
        if (root == p && root ==q){
            return new Result(root, true);
        }

        Result rx = findCommonAncestor(root.getLeftChild(), p, q);
        if (rx !=null){
            return rx;
        }

        Result ry = findCommonAncestor(root.getRightChild(), p, q);
        if (ry!=null){
            return ry;
        }
        if (rx!=null && ry!=null){
            return new Result(root,true);
        }else if (root == p || root==q){
            boolean isAncestor = rx !=null && rx.node !=null || ry!=null &&ry.node !=null ?true:false;
            return new Result(root, isAncestor);
        }else{
            return new Result(rx.node!=null ?rx.node:ry.node,false );
        }
    }

    TreeNode commonAncestor(TreeNode root,TreeNode p, TreeNode q){
        Result result = findCommonAncestor(root, p, q) ;
        if (result!=null){
            return result.node;
        }
        return null;
    }


    public static void main(String[] args){
        CommonAncestor_4_7 commonAncestor = new CommonAncestor_4_7();
        TreeNode root = new TreeNode(80);
        TreeNode node1 = new TreeNode(75);
        TreeNode node2 = new TreeNode(85);
        TreeNode node3 = new TreeNode(60);
        TreeNode node4 = new TreeNode(78);
        TreeNode node5 = new TreeNode(79);
        TreeNode node6 = new TreeNode(90);
        TreeNode node7 = new TreeNode(87);

        root.setLeftChild(node1);
        root.setRightChild(node2);
        node1.setLeftChild(node3);
        node1.setRightChild(node4);

        node2.setLeftChild(node5);
        node2.setRightChild(node6);
        node6.setRightChild(node7);

        TreeNode node = commonAncestor.commonAncestor(root, node3, node4);
        System.out.println(node);

    }
}
