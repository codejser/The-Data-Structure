package test;

import Array.array;

public class Main {

    public static void main(String[] args) {
	// write your code here
        array a = new array(20);
        for(int i=0;i<10;i++){
            a.addLast(i);
        }

        //a.add(3,200);
        //a.addFirst(50);
        System.out.println(a.toString());
        System.out.println(a.getSize());
    }
}
