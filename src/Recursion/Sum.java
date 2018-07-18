package Recursion;

/**
 * @Author: meteor @Date: 2018/7/17 13:23
 * 用递归的方法去计算数组的和
 */
public class Sum {

    public int sum(int[] arr){
        return sum(arr,0);
    }

    /**
     * l是数组中的索引
     * @param arr
     * @param l
     * @return
     */
    public int sum(int[] arr,int l){
        if(l == arr.length)
            return 0;
        return arr[l] + sum(arr,l+1);
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8};
        System.out.println((new Sum()).sum(a,0));
    }
}
