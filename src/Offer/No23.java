package Offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: meteor @Date: 2018/8/29 23:14
 * 从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印
 * 使用将二叉树的左右子树放入队列，在依次打印
 */
public class No23 {

    private static void levelPrint(TreeNode root){
        if (root == null){
            return;
        }

        Queue<TreeNode> treeNodeQueue = new LinkedList<TreeNode>();
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()){
            TreeNode node = treeNodeQueue.poll();
            System.out.println(node.getData());
            if (node.left != null){
                treeNodeQueue.add(node.left);
            }
            if (node.right != null){
                treeNodeQueue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(6);
        TreeNode d = new TreeNode(10);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(3);
        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        c.setRight(g);
        c.setLeft(f);
        levelPrint(a);
    }
}
