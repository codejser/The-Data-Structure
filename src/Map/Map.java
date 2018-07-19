package Map;

/**
 * @Author: meteor @Date: 2018/7/19 15:06
 * Map的接口：声明一些常用的方法
 */
public interface Map<K,V> {

    void add(K key,V value);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    void set(K key,V newValue);
    int getSize();
    boolean isEmpty();
}
