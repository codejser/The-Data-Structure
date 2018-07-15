package Queue;

import Array.DynamicArray;

/**
 * @Author: meteor @Date: 2018/7/15 16:52
 * 用动态数组实现队列
 */
public class ArrayQueue<E> implements Queue<E> {
    private DynamicArray<E> array ;

    public ArrayQueue(int capacity){
        array = new DynamicArray<E>(capacity);
    }

    public ArrayQueue(){
        array = new DynamicArray<E>();
    }


    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.getSize() == 0;
    }

    /**
     * 添加元素
     * @param e
     */
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    /**
     * 出队列，并删除元素
     * @return
     */
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("head [");
        for(int i=0;i<array.getSize();i++){
            sb.append(array.get(i));
            if(i != array.getSize()-1)
                sb.append(",");
        }
        sb.append("] tail");
        return sb.toString();
    }
}
