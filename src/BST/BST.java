package BST;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: meteor @Date: 2018/7/18 14:39
 * //构建一个二分搜索树：
 *      左子树的值小于根结点
 *      右子树的值大于根结点
 *
 */
public class BST<E extends Comparable<E>> {

    //构造结点
    private class Node{
        E e;
        Node left;
        Node right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    //根结点
    private Node root;
    //树的大小
    private int size;

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public BST(){
        root = null;
        size = 0;
    }


    //向树中添加新的元素：递归
    public void add(E e){
        root = add(root,e);
    }

    private Node add(Node node , E e){
        //递归的终止条件
        if(node == null){
            size ++;
            return new Node(e);
        }

        //把一个大问题分成若干个小问题
        if(e.compareTo(node.e) < 0)
            node.left = add(node.left,e);
        else
            node.right = add(node.right,e);

        return node;
    }

    //查询数中是否存在该元素
    public boolean contains(E e){
        return contains(root,e);
    }

    private boolean contains(Node node ,E e){
        //递归的终止条件
        if(node == null){
             return false;
        }

        //大问题划分为小的问题
        if(e.compareTo(node.e) == 0)
            return true;
        else if(e.compareTo(node.e) < 0)
            return contains(node.left,e);
        else
            return contains(node.right,e);

    }

    //前序遍历二叉搜索树：递归:所谓遍历就是打印其中的值
    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        //递归终止的条件
        if(node == null)
            return;

        //大的问题是：中左右
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);

    }

    //中序遍历二叉搜索树：递归:所谓遍历就是打印其中的值
    public void cenOrder(){
        cenOrder(root);
    }

    private void cenOrder(Node node){
        //递归终止的条件
        if(node == null)
            return;

        //大的问题是：左中右

        cenOrder(node.left);
        System.out.println(node.e);
        cenOrder(node.right);

    }


    //后序遍历二叉搜索树：递归:所谓遍历就是打印其中的值
    public void lastOrder(){
        lastOrder(root);
    }

    private void lastOrder(Node node){
        //递归终止的条件
        if(node == null)
            return;

        //大的问题是：左右中

        lastOrder(node.left);
        lastOrder(node.right);
        System.out.println(node.e);

    }

    //非递归版的前序遍历二分搜索树：借用栈的结构
    public void preOrderNR(){
        if(root == null)
            return;

        Stack<Node> s = new Stack<Node>();
        s.push(root);
        while (!s.isEmpty()){
            Node cur = s.pop();
            System.out.println(cur.e);


            if(cur.right != null){
                s.push(cur.right);
            }
            if(cur.left != null){
                s.push(cur.left);
            }
        }
    }


    //层次遍历二叉树：利用队列结构
    public void levelOrder(){
        if(root == null)
            return;

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()){
            Node cur = q.remove();
            System.out.println(cur.e);

            if(cur.left != null){
                q.add(cur.left);
            }
            if(cur.right != null){
                q.add(cur.right);
            }
        }
    }



    public static void main(String[] args) {

        BST<Integer> bst = new BST<Integer>();
        int[] nums = {5,3,6,8,4,2};
        for(int i=0;i<nums.length;i++){
            bst.add(nums[i]);
        }
        /*//bst.preOrder();
        //bst.cenOrder();
        //bst.lastOrder();
        //bst.preOrderNR();*/
        bst.levelOrder();
    }

}
