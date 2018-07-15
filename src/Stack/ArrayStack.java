package Stack;

import Array.DynamicArray;

/**
 * @Author: meteor @Date: 2018/7/15 11:17
 * 用动态数组来实现栈结构
 */
public class ArrayStack<E> implements Stack<E>{

    //声明一个动态数组
    DynamicArray<E> array;

    //对应的构造方法:设置对应的容量大小
    public ArrayStack(int capacity){
        array = new DynamicArray<E>(capacity);
    }

    //默认的构造方法：容量大小为10
    public ArrayStack(){
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

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        E temp = array.getLast();
        array.removeLast();
        return temp;
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Stack [");
        for(int i=0;i<array.getSize();i++){
            sb.append(i);
            if(i != array.getSize()-1)
                sb.append(",");
        }
        sb.append("] top");
        return sb.toString();
    }
}
