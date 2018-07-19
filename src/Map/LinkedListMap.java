package Map;

import java.util.ArrayList;

/**
 * @Author: meteor @Date: 2018/7/19 15:17
 */
public class LinkedListMap<K,V> implements Map<K,V> {

    //构建一个新的结点链表
    class Node{
        private K key;
        private V value;
        Node next;

        //结点的构造方法
        public Node(K key,V value,Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key,V value){
            this(key,value,null);
        }

        public Node(){
            this(null,null,null);
        }

        @Override
        public String toString(){
            return key.toString() + ":" + value.toString();
        }


    }


    //虚拟头结点
    private Node dummyNode;
    private int size;

    //LinkedListMap的构造方法
    public LinkedListMap(){
        dummyNode = new Node();
        size = 0;
    }

    /**
     * 根据K值来获取Node结点
     * @param key
     * @return
     */
    private Node getNode(K key){
        Node cur = dummyNode.next;
        while (cur != null){
            if(cur.key.equals(key)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }


    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if(node == null){
            //插入
            Node newNode = new Node(key,value);
            newNode.next = dummyNode.next;
            dummyNode.next = newNode;
            size ++;
        }else {
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node pre = dummyNode;
        while (pre.next != null){
            if(pre.next.key.equals(key))
                break;
            pre = pre.next;
        }

        if(pre.next != null){
            Node newNode = pre.next;
            pre.next = newNode.next;
            newNode.next = null;
            size -- ;
            return newNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null? null:node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    public static void main(String[] args){

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<String>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            LinkedListMap<String, Integer> map = new LinkedListMap<String, Integer>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();
    }
}
