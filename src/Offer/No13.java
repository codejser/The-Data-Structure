package Offer;

/**
 * @Author: meteor @Date: 2018/7/26 17:03
 * 剑指Offer第13题
 */
public class No13 {


    /**
     * 删除指定的入参结点
     * @param head
     * @param c
     */
    private static void delete(MyNode head, MyNode c){
        //三种情况：
        //1.删除的结点是尾结点；
        if(c.next == null){
            //从头结点去遍历整个链表找到尾结点的前一个结点
            while (head.next != c){
                head = head.next;
            }
            //循环结束后找到的是尾结点的前一个结点
            head.next = null;
        } else {                             //3.除了尾结点之外的其他结点；
            c.setData(c.getNext().getData());
            c.setNext(c.getNext().getNext());
        }

    }

    //测试delete方法
    public static void main(String[] args) {
        MyNode a = new MyNode(1);
        MyNode b = new MyNode(2);
        MyNode c = new MyNode(3);
        MyNode d = new MyNode(4);
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        //delete(a,b);
        delete(a,a);
        //delete(a,d);
        MyNode cur = a;
        while (cur != null){
            System.out.println(cur.getData());
            cur = cur.next;
        }
    }

}
