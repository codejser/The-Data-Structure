package Offer;

/**
 * @Author: meteor @Date: 2018/9/12 15:31
 * 输入一颗二叉树的根节点，求该树的深度。
 * 从根节点到叶节点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 */
public class No39 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);
        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        e.setLeft(g);
        g.setRight(h);
        c.setRight(f);
        System.out.println(IsBalanced_Solution(a));
    }

    //计算二叉树的深度
    public static int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return (left>right)?left+1:right+1;
    }

    //判断是否为平衡二叉树，直接根据定义去判断左右子树深度之差是否不超过1即可
    public static boolean IsBalanced_Solution(TreeNode root) {
        if (root == null){
             return true;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        int diff = left - right;
        if (diff>1 || diff <-1)
            return false;
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
}
