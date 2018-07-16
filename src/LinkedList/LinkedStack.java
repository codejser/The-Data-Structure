package LinkedList;

/**
 * @Author: meteor @Date: 2018/7/16 21:33
 */
public class LinkedStack<E> {

    LinkList<E> linkList;
    private int size;

    public LinkedStack(){
        linkList = new LinkList<E>();
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //进栈操作
    public void push(E e){
        linkList.addLast(e);
    }

    //出栈操作
    public E pop(){
        E peek = linkList.getLast();
        linkList.removeLast();
        return peek;
    }

    //查看栈顶的元素
    public E peek(){
        return linkList.getLast();
    }


    //重写toString方法：便于测试
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<linkList.getSize();i++){
            sb.append(linkList.get(i)+"->");
        }
        sb.append("NULL");
        return sb.toString();
    }



    public static void main(String[] args){
        LinkedStack<Integer> linkedStack = new LinkedStack<Integer>();
        for(int i=0;i<10;i++){
            linkedStack.push(i);
            System.out.println(linkedStack.toString());
        }
        System.out.println(linkedStack.pop());
    }

}
