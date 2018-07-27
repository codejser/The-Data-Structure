package Offer;

/**
 * @Author: meteor @Date: 2018/7/27 22:13
 */ //构造一个结点类
class MyNode{
    int data;
    MyNode next;

    public MyNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public MyNode getNext() {
        return next;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }
}
