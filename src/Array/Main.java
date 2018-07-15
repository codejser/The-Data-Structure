package Array;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /**arrayone a = new arrayone(20);
        for(int i=0;i<10;i++){
         a.addLast(i);
         }

        //a.add(3,200);
        //a.addFirst(50);
        System.out.println(a.toString());
        System.out.println(a.getSize());
         */

        /**
         * 测试动态数组扩容或者缩小
         */
        DynamicArray<Integer> array = new DynamicArray<Integer>(10);
        for(int i=0;i<10;i++){
            array.addLast(i);
        }
        array.addLast(5);

        System.out.println(array.toString());
        array.removeLast();
        array.removeLast();
        System.out.println(array.toString());


    }
}
