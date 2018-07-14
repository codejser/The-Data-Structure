package Array;

/**
 * @Author: meteor @Date: 2018/7/13 23:41
 * 设计一个普通的数组（非泛型:Int型）
 */
public class array {

    //私有属性
    private int[] data;         //数组
    private int size;           //数组的大小

    //构造方法:给一个数组的初始化容量
    public array(int capacity){
        data = new int[capacity];
    }

    //把有参数的构造方法封装到无参的构造方法中
    public array(){
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
    public void addLast(int element){

        //可以重用add(index,element)的方法
        add(size,element);
        /*if(size == data.length){
            throw new IllegalArgumentException("addLast fail , array is full");
        }
        data[size] = element;
        size ++;*/
    }

    //在所有的元素前加入一个元素
    public void addFirst(int element){
        //重用add(index,element)方法
        add(0,element);
    }
    //给定索引下插入元素
    public void add(int index,int element){
        if(size == data.length){
            throw new IllegalArgumentException("addLast fail , array is full");
        }

        if(index < 0){
            throw new IllegalArgumentException("addLast fail , index < 0");
        }
        //从后往前复制
        for(int i = size ;i > index; i--){
            data[i] = data[i-1];
        }
        data[index] = element;
        //维护size的大小
        size++;
    }


    //查看数组中是否包含该元素:查到返回返回True,查不到返回False
    public boolean contains(int element){
        //遍历数组
        for (int item : data){
            if(data[item] == element)
                return true;
        }
        return false;
    }

    //查找元素所对应的索引:查到返回下标，查不到返回-1
    public int find(int element){
        for (int item : data){
            if(data[item] == element)
                return item;
        }
        return -1;
    }

    //从数组中删除指定的元素,并返回删除的元素
    public int remove(int index){
        if(index <0 || index >= size){
            throw new IllegalArgumentException("get fail , index is illegal");
        }
        int ret = data[index];
        for(int i = index+1;i<size;i++){
            data[i-1] = data[i];
        }
        size --;

        return ret;
    }
    /**
     * 从数组中删除第一个元素,并返回删除的元素
     */
    public int removeFirst(){
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素，并返回删除的元素
     * @return
     */

    public int removeLast(){
        return remove(size-1);
    }

    /**
     * 删除数组中的某个元素
     * @param element
     */
    public void removeElement(int element){
        //先判断元素是否存在
        int index = find(element);
        if(index != -1){
            remove(index);
        }
    }
    //获取对应索引的元素
    int get(int index){
        if(index <0 || index >= size){
            throw new IllegalArgumentException("get fail , index is illegal");
        }
        return data[index];
    }

    //改变给定索引对应元素的值
    void set(int index,int element){
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
