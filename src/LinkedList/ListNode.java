package LinkedList;

/**
 * @Author: meteor @Date: 2018/7/17 12:53
 */
public class ListNode {

        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }


        //将传进来的数组转化成链表
        public ListNode(int[] arr){
            if(arr == null || arr.length == 0 ){
                throw new IllegalArgumentException("arr can not be empty");
            }
            this.val = arr[0];
            ListNode cur = this;
            for(int i=1;i<arr.length;i++){
                cur.next = new ListNode(arr[i]);
                cur = cur.next;
            }
        }

        //已当前节点为头节点的链表
        @Override
        public String toString(){
                StringBuilder sb = new StringBuilder();
                ListNode cur = this;
                while(cur != null){
                    sb.append(cur.val+"-->");
                    cur = cur.next;
                }
                sb.append("NULL");
                return sb.toString();
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

    public ListNode removeElements3(ListNode head, int val) {
        if(head == null)
            return head;

        head.next = removeElements3(head.next, val);
        return head.val == val ? head.next : head;
    }


        public static void main(String[] args){
              int[] arr = {1,2,6,3,4,5,6};
              ListNode listNode = new ListNode(arr);
              listNode.removeElements3(listNode,6);
              System.out.println(listNode.toString());
        }

}
