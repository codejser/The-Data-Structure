package Offer;

/**
 * @Author: meteor @Date: 2018/7/30 22:13
 *  请完成一个函数，输入一个二叉树，该函数输出它的镜像
 */
public class No19 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(8);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(2);
        a.setLeft(b);
        a.setRight(c);

        print(a);
        mirror(a);
        System.out.println();
        print(a);
    }

    /**
     * 打印二叉树的递归算法
     * @param root
     */
    private static void print(TreeNode root){
        if (root != null){
            System.out.print(root.data);
            print(root.left);
            print(root.right);
        }
    }

    /**
     * 输出二叉树的镜像
     * @param root
     */
    private static void mirror(TreeNode root){
        //递归终止的条件
        if(root == null){
            return;
        }
        if(root.left == null || root.right == null){
            return;
        }
        //交换非叶子结点的左右子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //开始递归
        if (root.left != null){
            mirror(root.left);
        }
        if (root.right != null){
            mirror(root.right);
        }

    }
}
