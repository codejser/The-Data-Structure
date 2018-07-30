package Offer;

/**
 * @Author: meteor @Date: 2018/7/28 22:08
 * 输入两颗二叉树A和B，判断B是不是A的子结构
 */
public class No18 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node5.setLeft(node6);
        node5.setRight(node7);

        TreeNode a = new TreeNode(8);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(2);
        a.setLeft(b);
        a.setRight(c);


        TreeNode d = new TreeNode(8);
        TreeNode e = new TreeNode(9);
        TreeNode f = new TreeNode(2);
        d.setLeft(e);
        d.setRight(f);

        System.out.println(isSubTree(d,a));
    }

    /**
     *
     * @param root1
     * @param root2
     * @return
     */
    private static boolean isSubTree(TreeNode root1, TreeNode root2){
        boolean result = false;

        if (root1 != null && root2 != null){
            if(root1.data == root2.data){
                result = isTree1HasTree2(root1,root2);
            }
            if(!result){
                result = isSubTree(root1.left,root2);
            }
            if(!result){
                result = isSubTree(root1.right,root2);
            }
        }

        return result;
    }

    private static boolean isTree1HasTree2(TreeNode root1, TreeNode root2) {
        if (root1 == null){
            return false;
        }
        if (root2 == null){
            return true;
        }

        if (root1.data != root2.data){
            return false;
        }

        return isTree1HasTree2(root1.left,root2.left) && isTree1HasTree2(root1.right,root2.right);

    }
}
