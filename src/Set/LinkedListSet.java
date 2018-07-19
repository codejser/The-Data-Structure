package Set;

import LinkedList.LinkList;

/**
 * @Author: meteor @Date: 2018/7/19 13:34
 * 用链表实现Set集合
 */
public class LinkedListSet<E> implements Set<E> {

    LinkList<E> linkList;

    public LinkedListSet(){
        linkList = new LinkList<E>();
    }

    @Override
    public void add(E e) {
        if(!linkList.contains(e)) {
            linkList.addFirst(e);
        }
    }

    @Override
    public boolean contains(E e) {
        return linkList.contains(e);
    }

    @Override
    public void remove(E e) {
        linkList.removeElement(e);
    }

    @Override
    public int getSize() {
        return linkList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkList.isEmpty();
    }
}
