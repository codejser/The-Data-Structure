package Queue;

/**
 * @Author: meteor @Date: 2018/7/15 16:52
 * 为队列设计一个接口
 */
public interface Queue<E> {
    //队列的大小
    int getSize();
    //队列是否为空
    boolean isEmpty();
    //添加元素
    void enqueue(E e);
    //删除元素，并返回
    E dequeue();
    //查找队首的元素
    E getFront();
}
