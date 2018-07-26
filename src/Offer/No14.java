package Offer;

/**
 * @Author: meteor @Date: 2018/7/26 22:29
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
public class No14 {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        move1(a);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]);
        }
    }

    /**
     * 解题思路：不考虑时间复杂度，对数组进行遍历，遇到偶数，就把这个偶数后面的
     * 全部数字往前挪一位，然后把偶数放到数组的末尾，遍历完成后奇数就排在了偶数
     * 的前面。
     * 时间复杂度：O（n^2）
     * 将数组按照要求排序
     * @param a
     */
    private static void move(int a[]){
        for(int i=0;i<a.length;i++){
            //如果是偶数
            if(a[i] % 2 == 0){
                int temp = a[i];
                for(int j=i+1;j<a.length;j++){
                    a[j-1] = a[j];
                }
                a[a.length-1] = temp;
            }
        }
    }

    /**
     *解题思路：用两个指针分别指向左右边界，
     * 指针移动的规则是：1.左边界小于右边界；2.左指针对应的数是奇数，左指针向右移动；
     * 3.右指针对应的数是偶数，右指针向左移动；
     * 指针移动的作用是保证当前左右指针所指向的是需要交换的两个数；
     * 循环结束的边界条件就是左指针大于等于右指针
     * @param a
     */
    private static void move1(int a[]){
        //维护数组的两个头尾指针
        int low = 0;
        int high = a.length-1;

        while (low < high){
            //维护头指针
            while(low<high && a[low] % 2 !=0){
                low++;
            }
            //维护尾指针
            while(low<high && a[high] % 2 ==0){
                high--;
            }
            //此时头尾指针所指向的数是需要交换的
            if (low < high){
                int temp = a[low];
                a[low] = a[high];
                a[high] = temp;
            }
            if(low >= high){
                break;
            }
        }

    }
}
