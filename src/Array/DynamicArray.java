package Array;

/**
 * @Author: meteor @Date: 2018/7/13 23:41
 * 设计一个动态数组
 */
public class DynamicArray<E> {

    //私有属性
    private E[] data;         //数组
    private int size;           //数组的大小

    //构造方法:给一个数组的初始化容量
    public  DynamicArray(int capacity){
        data = (E[])new Object[capacity];
    }

    //把有参数的构造方法封装到无参的构造方法中
    public  DynamicArray(){
        this(10);
        size = 0;
    }

    //判断数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //数组的大小
    public int getSize(){
        return size;
    }
    //向数组中所有元素后添加元素
    public void addLast(E element){

        //可以重用add(index,element)的方法
        add(size,element);
        /*if(size == data.length){
            throw new IllegalArgumentException("addLast fail , array is full");
        }
        data[size] = element;
        size ++;*/
    }

    //在所有的元素前加入一个元素
    public void addFirst(E element){
        //重用add(index,element)方法
        add(0,element);
    }
    //给定索引下插入元素
    public void add(int index,E element){


        if(index < 0){
            throw new IllegalArgumentException("addLast fail , index < 0");
        }
        //当数组的大小等于数组的长度时，进行扩容：扩容原来数组的两倍
        if(size == data.length){
            resize(data.length *2);
        }
        //从后往前复制
        for(int i = size ;i > index; i--){
            data[i] = data[i-1];
        }
        data[index] = element;
        //维护size的大小
        size++;
    }

    //数组扩容的方法
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for (int i=0;i<size;i++){
            newData[i] = data[i];
        }
        data = newData;
    }


    //查看数组中是否包含该元素:查到返回返回True,查不到返回False
    public boolean contains(E element){
        //遍历数组
       for(int i=0;i<size;i++){
           if(data[i] == element)
               return true;
       }
        return false;
    }

    //查找元素所对应的索引:查到返回下标，查不到返回-1
    public int find(E element){
        for(int i=0;i<size;i++){
            if(data[i] == element)
                return i;
        }
        return -1;
    }

    //从数组中删除指定的元素,并返回删除的元素
    public E remove(int index){
        if(index <0 || index >= size){
            throw new IllegalArgumentException("get fail , index is illegal");
        }
        //删除元素的时候，如果数组的大小等于数组长度的一半，就将数组减少一半
        if(size == data.length/2){
            resize(data.length/2);
        }
        E ret = data[index];
        for(int i = index+1;i<size;i++){
            data[i-1] = data[i];
        }
        size --;

        return ret;
    }
    /**
     * 从数组中删除第一个元素,并返回删除的元素
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素，并返回删除的元素
     * @return
     */

    public E removeLast(){
        return remove(size-1);
    }

    /**
     * 删除数组中的某个元素
     * @param element
     */
    public void removeElement(E element){
        //先判断元素是否存在
        int index = find(element);
        if(index != -1){
            remove(index);
        }
    }
    //获取对应索引的元素
    E get(int index){
        if(index <0 || index >= size){
            throw new IllegalArgumentException("get fail , index is illegal");
        }
        return data[index];
    }

    //改变给定索引对应元素的值
    void set(int index,E element){
        if(index <0 || index >= size){
            throw new IllegalArgumentException("set fail , index is illegal");
        }
        data[index] = element;
    }




    //利用StringBuilder来拼接toString的方法
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(String.format("array: size=%d,capacity=%d\n",size,data.length));
        s.append("[");
        for(int i=0;i<size;i++){
            s.append(data[i]);
            if(i != size-1)
                s.append(",");
        }
        s.append("]");
        return s.toString();
    }



}
