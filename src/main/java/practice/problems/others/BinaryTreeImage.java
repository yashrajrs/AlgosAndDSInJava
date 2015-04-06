package practice.problems.others;

import practice.dataStructures.trees.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: yashrajsontakke
 * Date: 3/31/15
 * Time: 11:26 PM
 * To change this template use File | Settings | File Templates.
 *
 * @author Yashraj R. Sontakke
 */
public class BinaryTreeImage {

    public boolean isImage(TreeNode node1, TreeNode node2){
        if (node1 == null && node2 == null){
            return true;
        }else if (node1==null || node2 == null){
            return false;
        }
        if (!isImage(node1.getLeftChild(), node2.getRightChild())){
            return false;
        }
        if (node1.getData() !=node2.getData()){
            return false;
        }
        return isImage(node1.getRightChild(), node2.getLeftChild());
    }

    public static void main(String[] args){
        TreeNode node11 = new TreeNode(10);
        TreeNode node12 = new TreeNode(20);
        TreeNode node13 = new TreeNode(30);
        TreeNode node14 = new TreeNode(40);
        TreeNode node15 = new TreeNode(50);


        TreeNode node21 = new TreeNode(10);
        TreeNode node22 = new TreeNode(20);
        TreeNode node23 = new TreeNode(30);
        TreeNode node24 = new TreeNode(40);
        TreeNode node25 = new TreeNode(50);

        node11.setLeftChild(node12);
        node11.setRightChild(node13);
        node12.setLeftChild(node14);
        node12.setRightChild(node15);

        node21.setLeftChild(node23);
        node21.setRightChild(node22);
        node22.setLeftChild(node25);
        node22.setRightChild(node24);



        BinaryTreeImage binaryTreeImage = new BinaryTreeImage();

        System.out.println(binaryTreeImage.isImage(node11,node21));

        node25.setLeftChild(new TreeNode(122));
        System.out.println(binaryTreeImage.isImage(node11,node21));

    }
}
