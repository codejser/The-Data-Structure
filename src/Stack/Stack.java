package Stack;

/**
 * @Author: meteor @Date: 2018/7/15 13:08
 * 定义一个栈的接口
 */
public interface Stack<E> {

    //栈的大小
    int getSize();
    //栈是否为空
    boolean isEmpty();
    //进栈方法
    void push(E e);
    //出栈，并返回相应的元素
    E pop();
    //查看当前的栈顶元素
    E peek();
}
