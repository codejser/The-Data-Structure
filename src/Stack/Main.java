package Stack;

/**
 * @Author: meteor @Date: 2018/7/15 13:26
 * 测试栈结构
 */
public class Main {
    public static void main(String[] args){
        ArrayStack<Integer> arrayStack = new ArrayStack<Integer>();
        for(int i=0;i<10;i++){
            arrayStack.push(i);
            System.out.println(arrayStack.toString());
        }
        System.out.println(arrayStack.getSize());
        System.out.println(arrayStack.isEmpty());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.peek());
    }
}
