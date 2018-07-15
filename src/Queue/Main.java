package Queue;

/**
 * @Author: meteor @Date: 2018/7/15 17:05
 */
public class Main {
    public static void main(String[] args){
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<Integer>();
        for (int i = 0; i < 10 ; i++) {
            arrayQueue.enqueue(i);
        }
        System.out.println(arrayQueue.toString());


        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.toString());
        System.out.println(arrayQueue.getFront());
    }
}
