package Sort;

/**
 * @Author: meteor @Date: 2018/9/28 16:52
 * 快速排序
 */
public class QuicklySort {

    public static void main(String[] args) {
        int[] a = {7,5,8,9,4,3,6};
        sort(a);
        for (int c:a){
            System.out.print(c);
        }
    }

    //排序算法
    public static void sort(int[] a){
        sort3(a,0,a.length-1);
    }

    /**
     * lo 数组的左指针
     * hi 数组的右指针
     * @param a
     * @param lo
     * @param hi
     */
    private static void sort(int[] a, int lo, int hi) {
        if (hi<=lo) return;     //递归结束的条件
        int j = qiefen(a,lo,hi);        //切分函数找到切分元素
        sort(a,lo,j-1);         //递归快排左序列
        sort(a,j+1,hi);               //递归快排右序列
    }

    /**
     * 切分函数：以数组a的第一个元素为起始切分元素，进行第一步切分
     * 以切分元素为界限，左序列元素全部小于切分元素
     * 右序列元素全部大于切分元素
     * 默认数组第一位为0，则有可能导致复杂度提高，比如当默认数位最大值时，需要做很多次交换;
     * 可以随机选取起始的切分元素，来降低极端情况的概率;
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    private static int qiefen(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi+1;
        int k = a[lo];     //切分元素
        while (true){
            while (a[++i]<k)if (i==hi) break;//直到找到大于切分元素的下标时，循环终止
            while (k<a[--j])if (j==lo) break;
            if (i>=j) break;
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        int temp = a[lo];
        a[lo] = a[j];
        a[j] = temp;
        return j;
    }

    /**
     * 三向切分快排算法;解决切分元素重复值较多的情况
     * 思路：把排序数组分为三个部分：
     * lo--lt:小于切分元素
     * lt--gt:等于切分元素
     * gt--hi:大于切分元素
     * @param a
     * @param lo
     * @param hi
     */
    private static void sort3(int[] a, int lo, int hi) {
        if (lo>hi) return;
        int lt = lo;
        int i = lo+1;
        int gt = hi;
        int v = a[lo];
        while (i<=gt){
            if (a[i]<v){
                int temp = a[i];
                a[i] = a[lt];
                a[lt] = temp;
                i++;
                lt++;
            }else if (a[i]>v){
                int temp = a[i];
                a[i] = a[gt];
                a[gt] = temp;
                gt--;
            }else {
                i++;
            }
        }
        //递归排序除了切分元素重复的子序列
        sort3(a,lo,lt-1);
        sort3(a,gt+1,hi);
    }



}
