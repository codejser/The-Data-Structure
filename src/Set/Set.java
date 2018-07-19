package Set;

/**
 * @Author: meteor @Date: 2018/7/19 13:32
 * Set集合的接口：声明一些方法
 */
public interface Set<E> {

    void add(E e);
    boolean contains(E e);
    void remove(E e);
    int getSize();
    boolean isEmpty();
}
