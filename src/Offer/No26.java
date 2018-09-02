package Offer;

/**
 * @Author: meteor @Date: 2018/9/2 14:09
 * 剑指Offer第26题：
 * 请实现函数ComplexListNode* Clone(ComplexListNode* pHead)，
 * 复制一个复杂链表。在复杂链表中，
 * 每个结点除了有一个m_pNext指针指向下一个结点外，
 * 还有一个m_pSibling指向链表中的任意结点或者NULL
 */
public class No26 {

    //main方法
    public static void main(String[] args) {
        complexNode a = new complexNode(1);
        complexNode b = new complexNode(2);
        complexNode c = new complexNode(3);
        complexNode d = new complexNode(4);
        complexNode e = new complexNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        a.other = c;
        b.other = e;
        d.other = b;
        complexNode head = clone(a);
        /*while (head != null){
            System.out.println(head.data);
            head = head.next;
        }*/
    }

    //复制方法
    public static complexNode clone(complexNode head){
        //主要分为三个步骤
        // 1.将给定的复杂链表的每个结点后面设置成相同的结点---比如给定12345  设置成1122334455
        // 2.将1中复杂链表每个结点的other结点处理完毕
        // 3.将奇数和偶数位置的结点分开，返回偶数位置的结点，然后返回偶数位置的结点链表
        cloneNode(head);
        setOtherNode(head);
        return devideNode(head);
    }

    //第三步
    private static complexNode devideNode(complexNode head) {
        //分离复杂链表
        complexNode node = head;
        //循环结点
        complexNode cloneNode = null;
        //返回链表的头结点
        complexNode cloneHead = null;

        //确定返回链表的头结点
        if (node != null){
            cloneNode = node.next;
            cloneHead = cloneNode;
            node.next = cloneNode.next;
            node = node.next;
        }
        while (node != null){
            cloneNode.next = node.next;
            cloneNode = cloneNode.next;
            node.next = cloneNode.next;
            node = node.next;
        }
        return cloneHead;
    }

    //第二步
    private static void setOtherNode(complexNode head) {
        complexNode node = head;
        while (node != null){
            complexNode cloneNode = node.next;
            if (node.other != null){
                cloneNode.other = node.other.next;
            }
            node = cloneNode.next;
        }
    }

    //第一步
    private static void cloneNode(complexNode head) {
        complexNode node = head;
        while (node != null){
            complexNode cloneNode = new complexNode(node.data);
            cloneNode.next = node.next;
            node.next = cloneNode;
            node = cloneNode.next;
        }
    }
}

//复杂链表结点
class complexNode{
    int data;
    //指向下一个结点
    complexNode next;
    //指向一个随机的结点或者null
    complexNode other;

    //初始化构造函数
    public complexNode(int data){
        this.data = data;
    }
}
