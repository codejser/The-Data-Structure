package Sort;

/**
 * @Author: meteor @Date: 2018/9/12 10:49
 * 归并排序
 * 原理是分治法
 *分:把数组分成两个有序序列，直到序列的个数为1
 *治:是把分成的若干个序列分别排序
 *整个过程就是把递归地把两个有序序列合并成一个有序序列
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a = {4,5,7,6,8};
        sort(a);
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]);
        }
    }
    
    
    private static void sort(int a[]){
        int[] arr = new int[a.length];
        //归并时用到的辅助数组
        for (int i=0;i<a.length;i++){
            arr[i] = a[i];
        }
        Sort(a,arr,0,a.length-1);
    }
    //归并函数
    private static void Sort(int[] a, int[] arr, int lo, int hi ) {
        if (lo>=hi) return;
        int mid = (lo+hi)/2;
        Sort(a,arr,lo,mid);
        Sort(a,arr,mid+1,hi);
        merge(a,arr,lo,mid,hi);
    }

    private static void merge(int[] a, int[] arr, int lo, int mid, int hi) {
        int i = lo;
        int j = mid+1;
        int k = lo;
        while (i<=mid && j<=hi){
            if (arr[i]<arr[j]){
                a[k++] = arr[i++];
            }else {
                a[k++] = arr[j++];
            }
        }

        while (i<=mid){
            a[k++] = arr[i++];
        }
        while (j<=hi){
            a[k++] = arr[j++];
        }
    }
}
