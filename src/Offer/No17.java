package Offer;

/**
 * @Author: meteor @Date: 2018/7/28 21:52
 * 合并两个排序的链表
 *
 */
public class No17 {
    //单元测试
    public static void main(String[] args) {
        MyNode a = new MyNode(1);
        MyNode b = new MyNode(3);
        MyNode c = new MyNode(5);
        MyNode d = new MyNode(7);
        MyNode e = new MyNode(2);
        MyNode f = new MyNode(4);
        MyNode g = new MyNode(6);
        MyNode h = new MyNode(8);
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        e.setNext(f);
        f.setNext(g);
        g.setNext(h);
        MyNode newNode = merge(a,e);
        while (newNode != null){
            System.out.print(newNode.data);
            newNode = newNode.next;
        }
    }

    /**
     * 合并的方法
     * 参数分别为两个链表的头结点
     * @param head1
     * @param head2
     * @return
     */
    private static MyNode merge(MyNode head1,MyNode head2){
        //鲁棒性
        if(head1 == null){
            return head2;
        }
        if (head2 == null){
            return head1;
        }
        if (head1 == null && head2 == null){
            return null;
        }

        //合并后新链表的头结点
        MyNode newHead = null;
        //递归的思想去合并两个已经排序的列表；新链表也是有序的
        if(head1.data < head2.data){
            newHead = head1;
            newHead.next = merge(head1.next,head2);
        }else {
            newHead = head2;
            newHead.next = merge(head1,head2.next);
        }

        return newHead;
    }

}
