package Offer;

import java.util.LinkedList;

/**
 * @Author: meteor @Date: 2018/9/15 11:11
 * 0~n-1这n个数字排列成一个圆圈，
 * 从数字0开始每次从这个圆圈中删除第m个数字。
 * 求出这个圆圈里剩下的最后一个数字
 */
public class No45 {

    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution1(5,3));
    }

    /**
     * LinkedList
     * @param n
     * @param m
     * @return
     */
    public static int LastRemaining_Solution(int n, int m) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i=0;i<n;i++){
            list.add(i);
        }

        int index = 0;
        while (list.size()>1){
            index = (index+m-1)%list.size();
            list.remove(index);
        }

        return list.get(0);
    }

    /**
     * 构造循环链表，
     * 删除指定的m结点
     * 删除找到的结点，并更新新的头结点
     * @param n
     * @param m
     * @return
     */
    public static int LastRemaining_Solution1(int n, int m){
        MyNode head = new MyNode(0);
        MyNode pre = head;
        MyNode temp = null;
        //循环构建链表 (1--n 结点值)
        for (int i=1;i<n;i++){
            temp = new MyNode(i);
            pre.next = temp;
            pre = temp;
        }
        //尾结点指向头结点
        temp.next = head;

        //删除指定的m结点
        MyNode cur = null;
        while (n>1){
            cur = head;
            //链表中删除结点的方法就是找到此节点的前一个结点
            for (int i=1;i<m-1;i++){
                cur = cur.next;
            }
            //删除找到的结点，并更新新的头结点
            cur.next = cur.next.next;
            head = cur.next;
            n--;
        }
        return head.data;
    }

}
