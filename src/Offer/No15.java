package Offer;

/**
 * @Author: meteor @Date: 2018/7/27 13:26
 * 剑指Offer第15题
 * 输入一个链表，输出该链表中倒数第K个结点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾结点是倒数第1个结点。
 * 例如一个链表有6个结点，从头结点开始它们的值依次是1,2,3,4,5,6。
 * 这个链表的倒数第3个结点是值为4的结点。
 * （注意代码鲁棒性，考虑输入空指针，链表结点总数少于k，输入的k参数为0）
 */
public class No15 {

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
        //get(a,5);
        //System.out.println(getNodeCount(a));
        //System.out.println( get1(a,4));
        //System.out.println( get1(null,4));
        //System.out.println( get1(a,0));
        //System.out.println( get1(a,6));

    }

    /**
     * 找到列表中的倒数第K个节点
     * 需要遍历两次链表；
     * 没有考虑程序的鲁棒性，需要进行防御性编程：
     * 1.输入的链表为空；
     * 2.输入的链表总结点个数小于输入的参数K；
     * 3.K值为0；
     * @param head
     * @param K
     */
    private static int get(MyNode head,int K){
        //k表示倒数第K个节点对应的正数第k个节点
        //k,K,链表的总结点n之间的关系是：k = n+1-K;
        int k = getNodeCount(head)+1 - K;

        if(getNodeCount(head) == 0){
            System.out.println("链表为空");
            return 0;
        }
        if(getNodeCount(head) < K){
            System.out.println("参数出错，链表的节点数小于K值");
            return 0;
        }
        if(K == 0){
            System.out.println("参数K必须大于0");
            return 0;
        }
        //再从头节点遍历到第k个节点；
        MyNode cur = head;
        while (k>1){
            cur = cur.next;
            k--;
        }
       return cur.getData();

    }

    /**
     * 获取链表的节点个数
     * @param head
     * @return
     */
    private static int getNodeCount(MyNode head){
        int count = 0;
        MyNode cur = head;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    /**
     * 使用两个指针来确定K的位置
     * 考虑程序的鲁棒性：
     * 1.输入的链表为空；
     * 2.输入的链表总结点个数小于输入的参数K；
     * 3.K值为0；
     * @param head
     * @param K
     * @return
     */
    private static int get1(MyNode head,int K){

        //声明两个指针
        MyNode first = head;
        MyNode last = head;

        //如果头结点为空或者K等于0；结束程序
        if(head == null || K == 0){
            return 0;
        }
        //如果K的值大于总的节点数；那么在first指针移动的过程中一定会出现指针为空；
        //first指针先移动K-1个位置
        for(int i=0;i<K-1;i++){
            if(first.next != null) {
                first = first.next;
            }else {
                return 0;
            }
        }

        //last指针和first指针同时移动
        while (first.next != null){
            first = first.next;
            last = last.next;
        }

        return last.getData();

    }

}


