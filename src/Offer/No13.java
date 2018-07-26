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
    private static void delete(myNode head,myNode c){
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
        myNode a = new myNode(1);
        myNode b = new myNode(2);
        myNode c = new myNode(3);
        myNode d = new myNode(4);
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        //delete(a,b);
        delete(a,a);
        //delete(a,d);
        myNode cur = a;
        while (cur != null){
            System.out.println(cur.getData());
            cur = cur.next;
        }
    }

}


//构造一个结点类
class myNode{
    int data;
    myNode next;

    public myNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public myNode getNext() {
        return next;
    }

    public void setNext(myNode next) {
        this.next = next;
    }
}
