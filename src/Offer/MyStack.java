package Offer;

import java.util.Stack;

/**
 * @Author: meteor @Date: 2018/7/30 23:05
 * 构建一个特殊的栈，添加min函数
 */
public class MyStack {

    //数据栈:存放进栈的数据
    Stack<Integer> stack;

    //辅助栈:栈顶用来存储最小元素
    Stack<Integer> stackHelper;
    //初始化两个栈
    public MyStack(){
        stack = new Stack<Integer>();
        stackHelper = new Stack<Integer>();
    }

    /**
     * 进栈操作：
     * 数据栈存储元素：如果辅助栈为空，
     * 或者当前进栈元素小于辅助栈的最小元素（即进栈元素），
     * 则将当前进栈元素更新为最小元素（即栈顶元素）；
     * 如果当前进栈元素大于辅助栈的栈顶元素，
     * 说明当前的进栈元素不是数据栈中的最小值；
     * 此时应该将栈顶元素（即最小元素）再次插入到栈顶元素，
     * 维护当时的最小元素仍然为栈顶元素。
     * @param num
     */
    public void push(Integer num){
        stack.push(num);
        if (stackHelper.size() == 0 || num < stackHelper.peek()){
            stackHelper.push(num);
        }else {
            stackHelper.push(stackHelper.peek());
        }
    }

    /**
     * 出栈操作
     */
    public void pop(){
        stack.pop();
        stackHelper.pop();
    }

    /**
     * 最小值函数：去辅助栈的栈顶元素即可
     * @return
     */
    public Integer min(){
        if (stackHelper.size() == 0)
            return null;
        else
            return stackHelper.peek();
    }

}
