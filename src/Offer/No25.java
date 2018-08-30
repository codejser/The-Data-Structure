package Offer;


import java.util.Stack;

/**
 * @Author: meteor @Date: 2018/8/30 09:50
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。

 */
public class No25 {

    /**
     * root:根节点   sum:和
     * @param root
     * @param sum
     */
    private static void findPath(TreeNode root,int sum){
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int currentNum = 0;
        findPath1(root,stack,sum,currentNum);
    }

    /**
     *
     * @param root
     * @param stack
     * @param sum
     * @param currentNum
     */
    private static void findPath1(TreeNode root, Stack<TreeNode> stack, int sum, int currentNum) {
        stack.push(root);
        currentNum+=root.getData();
        if (root.left != null){
            findPath1(root.left,stack,sum,currentNum);
        }
        if (root.right != null){
            findPath1(root.right,stack,sum,currentNum);
        }
        if (root.left == null &&root.right == null){
            if (currentNum == sum){
               //封装一个倒序打印栈的方法
                printStack(stack);
            }
        }

        stack.pop();
    }

    /**
     * 打印栈元素，打印顺序为栈底到栈顶
     * @param stack
     */
    private static void printStack(Stack<TreeNode> stack) {
        //借助辅助栈
        Stack<TreeNode> tempStack = new Stack<TreeNode>();
        //将当前栈放入辅助栈，实现逆序
        while (!stack.isEmpty()){
            tempStack.add(stack.pop());
        }

        //打印辅助栈
        while (!tempStack.isEmpty()){
            TreeNode node = tempStack.pop();
            System.out.print(node.getData() + " ");
            //恢复原栈的顺序
            stack.add(node);
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(10);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(7);
        TreeNode e = new TreeNode(12);
        a.setLeft(b);
        a.setRight(e);
        b.setLeft(c);
        b.setRight(d);
        findPath(a,22);
    }
}
