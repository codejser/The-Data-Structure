package LeetCode;

/**
 * @Author: meteor @Date: 2018/7/17 12:24
 * 删除链表中等于给定值 val 的所有节点。示例:
    输入: 1->2->6->3->4->5->6, val = 6
    输出: 1->2->3->4->5
 *
 */
public class Lcode203 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * removeElements1:没有虚拟头节点的方法
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements1(ListNode head, int val) {
        //如果头节点的值为给定val的值
        if(head != null && head.val == val){
            head = head.next;
        }
        //如果头节点为空
        if(head == null){
            return head;
        }

        //删除其他节点的方法
        ListNode prev = head;
        while (prev.next != null){
            if(prev.next.val == val)
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }
        return head;

    }

    /**
     * removeElements1:有虚拟头节点的方法
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;


        ListNode prev = dummyNode;
        while (prev.next != null){
            if(prev.next.val == val)
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }
        return head;
    }

}
