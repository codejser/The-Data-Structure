package Offer;

import LinkedList.ListNode;

/**
 * @Author: meteor @Date: 2018/9/10 18:45
 * 输入两个单向链表，找出它们的第一个公共结点。
 */
public class No37 {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(6);
        ListNode e = new ListNode(7);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode a1 = new ListNode(4);
        ListNode b1 = new ListNode(5);
        ListNode c1 = new ListNode(6);
        ListNode d1 = new ListNode(7);
        a1.next = b1;
        b1.next = c1;
        c1.next = d1;
        ListNode newNode = FindFirstCommonNode2(a,a1);
        System.out.println(newNode.val);

    }

    /**
     * 时间复杂度为O(nm);n和m是链表的长度
     * @param pHead1
     * @param pHead2
     * @return
     */
    public static ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        ListNode curNode1 = pHead1;
        ListNode curNode2 = pHead2;
        ListNode resultNode = null;
        boolean flag = false;

        while (curNode1 != null){
            while (curNode2 != null){
                if ((curNode1.val == curNode2.val) && (curNode1.next.val == curNode2.next.val)){
                    resultNode = curNode1;
                    flag = true;
                    break;
                }else
                    curNode2 = curNode2.next;
            }
            if (flag)
                break;
            else
                curNode1 = curNode1.next;
        }
        return resultNode;
    }

    /**
     * 时间复杂度为O(m+n) n和m是链表的长度
     * @param pHead1
     * @param pHead2
     * @return
     */
    public static ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2){
        //长链表
        ListNode longListNode = null;
        //短链表
        ListNode shortListNode = null;
        //计算链表的长度
        int len1 = getListNodeLen(pHead1);
        int len2 = getListNodeLen(pHead2);
        int diff = 0;
        //计算长度差
        if (len1<len2){
            longListNode = pHead2;
            shortListNode = pHead1;
            diff = len2 - len1;
        }else{
            longListNode = pHead1;
            shortListNode = pHead2;
            diff = len1 - len2;
        }
        //遍历长链表diff个长度
        for(int i=0;i<diff;i++){
            longListNode = longListNode.next;
        }

        //同时遍历两个链表
        while (longListNode != null && shortListNode != null
                && longListNode.val != shortListNode.val){
            longListNode = longListNode.next;
            shortListNode = shortListNode.next;
        }
        return longListNode;
    }

    private static int getListNodeLen(ListNode pHead1) {
        ListNode cur = pHead1;
        int count = 0;
        while (cur != null){
            cur = cur.next;
            count++;
        }
        return count;
    }

}

