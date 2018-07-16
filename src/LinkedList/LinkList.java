package LinkedList;

import com.sun.org.glassfish.gmbal.ManagedObject;

/**
 * @Author: meteor @Date: 2018/7/16 19:02
 * 链表的设计
 */
public class LinkList<E> {

    //设计链表中的结点
    private class Node{
        E data;
        Node next;

        public Node(E data,Node next){
            this.data = data;
            this.next = next;
        }

        public Node(E data){
            this(data,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return data.toString();
        }
    }

    //链表的头结点
   /* Node head = null;*/
   //链表的虚拟头结点
    private Node dummyNode;
    //链表的长度
    private int size;

    //链表的构造方法
    public LinkList(){
        dummyNode = new Node(null,null);
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //在某个索引出添加结点
    public void addIndex(int index,E data){
        if(index < 0 || index > size ){
            throw new IllegalArgumentException("add fail , index is illegal");
        }
        //在某个索引添加结点的方法就是：
        Node prev = dummyNode;
        for(int i=0;i<index;i++){
            prev = prev.next;
        }
        Node newNode = new Node(data);
        newNode.next = prev.next;
        prev.next = newNode;
        //prev.next = new Node(data,prev.next);
        size ++;
    }

    //在头结点处添加元素
    public void addFirst(E data){
        addIndex(0,data);
      /*  Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;

        //head = new Node(data,head);*/
    }

    //在链表的尾部插入结点
    public void addLast(E data){
        //直接调用index
        addIndex(size,data);
    }

    //获取链表中的某个结点的值:采用index的方法
    public E get(int index){
        if(index < 0 || index > size ){
            throw new IllegalArgumentException("get fail , index is illegal");
        }
        //已第一个结点为其实结点
        Node cur = dummyNode.next;
        for(int i=0;i<index;i++)
            cur = cur.next;
        return cur.data;
    }

    //获取链表中的第一个结点
    public E getFirst(){
        return get(0);
    }

    //获取链表中的第一个结点
    public E getLast(){
        return get(size-1);
    }

    //修改链表第index位置上的值
    public void set(int index,E e){
        if(index < 0 || index > size ){
            throw new IllegalArgumentException("set fail , index is illegal");
        }

        Node cur = dummyNode.next;
        for(int i=0;i<index;i++)
            cur = cur.next;
        cur.data = e;
    }

    /**
     * 链表中是否包含某个元素
     * 如果存在，返回true;否则，返回false
     */
    public boolean contains(E data){
        Node cur = dummyNode.next;
        while(cur != null){
            if(cur.data == data){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //重写toString方法：便于测试
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Node cur = dummyNode.next; cur != null; cur = cur.next){
            sb.append(cur.data+"->");
        }
        sb.append("NULL");
        return sb.toString();
    }


    public static void main(String[] args){
        LinkList<Integer> linkList = new LinkList<Integer>();
        for(int i=0;i<5;i++){
            linkList.addFirst(i);
            System.out.println(linkList.toString());
        }

        linkList.addIndex(3,8);
        System.out.println(linkList.toString());
        System.out.println(linkList.contains(1));
        linkList.set(2,10);
        System.out.println(linkList.toString());
        System.out.println(linkList.getLast());

    }




}
