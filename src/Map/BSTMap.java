package Map;

import java.security.Key;
import java.util.ArrayList;

/**
 * @Author: meteor @Date: 2018/7/19 16:45
 * 基于二分搜索树的Map集合
 */
public class BSTMap<K extends Comparable<K>,V> implements Map<K,V> {

    class Node{
        private K key;
        private V value;
        Node left;
        Node right;

        public Node(K key,V value,Node left,Node right){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(K key,V value){
            this(key,value,null,null);
        }

        public Node(){
            this(null,null,null,null);
        }

    }

    private Node root;
    private int size;

    public BSTMap(){
        root = new Node();
        size = 0;
    }




    @Override
    public void add(K key, V value) {
        root = add(root,key,value);
    }


    private Node add(Node node,K key,V value){
        if(node == null){
            size ++;
            node = new Node(key,value);
        }

        if(key.compareTo(node.key) < 0)
            node.left = add(node.left,key,value);
        else if(key.compareTo(node.key) > 0)
            node.right = add(node.right,key,value);
        else
            node.value = value;
        return node;
    }


    private Node getNode(Node node,K key){
        if(node == null){
            return null;
        }

        if(key.equals(node.key))
            return node;
        else if(key.compareTo(node.key) < 0)
            return getNode(node.left,key);
        else
            return getNode(node.right,key);

    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root,key) != null;
    }

    @Override
    public V get(K key) {
        return getNode(root,key).value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root,key);
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

            BSTMap<String, Integer> map = new  BSTMap<String, Integer>();
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
