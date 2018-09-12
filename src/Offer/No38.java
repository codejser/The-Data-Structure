package Offer;

/**
 * @Author: meteor @Date: 2018/9/12 14:58
 * 统计一个数字在排序数组中出现的次数。
 * 例如输入排序数组{1,2,3,3,3,3,4,5}和数字3，
 * 由于3在这个数组中出现了4次，因此输出4
 */
public class No38 {
    /**
     * 思路一：直接遍历整个数组,但是太简单暴力，复杂度为0(n);代码简单，不再赘述；
     * 思路二：因为整个数组是有序的 可以考虑使用二分查找的思想,来找到重复数字第一次
     * 出现的位置和最后一次出现的位置，即可算出重复出现的次数
     * 具体思路请查看剑指offer38题的思路
     */

    public static void main(String[] args) {
        int[] a = {1,2,3,3,3,3,4,5};
        System.out.println(GetNumberOfK(a,3));
    }

    public static int GetNumberOfK(int [] array , int k) {
        int num = 0;
        if (array ==null || array.length ==0){
            return -1;
        }
        int first = GetFirstK(array,k,0,array.length-1);
        int end = GetLastK(array,k,0,array.length-1);
        if (first>-1 && end >-1) {
            num = end - first + 1;
        }
        return num;
    }

    /**
     * 返回第一次出现k的索引
     * @param array
     * @param k
     * @return
     */
    public static int GetFirstK(int [] array , int k,int start,int end) {
        if (start > end)
            return -1;
        int mid = (start+end)/2;
        if (array[mid] == k){
            if (array[mid-1]!=k && mid>0){
                //mid为所求下标
                return mid;
            }else {
                end = mid-1;
            }
        }else if (array[mid]>k){
                end = mid-1;
        }else
            start = mid+1;
        return GetFirstK(array,k,start,end);
    }

    /**
     * 返回最后一次出现k的索引
     * @param array
     * @param k
     * @return
     */
    public static int GetLastK(int [] array , int k,int start,int end) {
        if (start >= end)return -1;
        int mid = (start+end)/2;
        if (array[mid] == k){
            if (mid<end && array[mid+1]!=k){
                return mid;
            }else {
                start = mid+1;
            }
        }else if (array[mid]>k){
            end = mid-1;
        }else
            start = mid+1;
        return GetLastK(array,k,start,end);
    }
}
