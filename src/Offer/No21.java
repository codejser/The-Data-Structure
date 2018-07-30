package Offer;

/**
 * @Author: meteor @Date: 2018/7/30 22:44
 * 定义栈的数据结构，请在该类型中实现一个能够得到
 * 栈的最小元素的min函数。
 * 在该栈中，调用min、push以及pop的时间复杂度都是O(1)。
 */
public class No21 {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(10);
        myStack.push(11);
        myStack.push(9);
        System.out.println(myStack.min());
    }
}
