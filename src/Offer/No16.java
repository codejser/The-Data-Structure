package Offer;

import javafx.scene.input.Mnemonic;

/**
 * @Author: meteor @Date: 2018/7/27 22:12
 * 定义一个函数，输入一个链表的头结点，
 * 反转该链表并输出反转后链表的头结点
 */
public class No16 {

    public static void main(String[] args) {
        MyNode a = new MyNode(1);
        MyNode b = new MyNode(2);
        MyNode c = new MyNode(3);
        MyNode d = new MyNode(4);
        MyNode e = new MyNode(5);
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        MyNode newNode = reverse(a);
        while (newNode != null){
            System.out.print(newNode.getData());
            newNode = newNode.next;
        }

    }


    /**
     * 反转链表
     * @param head
     */
    private static MyNode reverse(MyNode head){
        MyNode pre = head;
        MyNode cur = head.next;
        MyNode temp;

        while (cur != null){
            temp = cur.next;
            cur.setNext(pre);
            pre = cur;
            cur = temp;
        }
        head.next = null;
        return pre;
    }
}
