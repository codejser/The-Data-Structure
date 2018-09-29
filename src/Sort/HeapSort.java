package Sort;

/**
 * @Author: meteor @Date: 2018/9/28 17:15
 * 堆排序:构造堆；
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] a ={0,5,4,17,13,15,12,10};
        Sort(a);
        for (int c:a){
            System.out.print(c);
        }
    }

    //构建堆结构(大根堆，根节点大于子节点)
    //用的方法是由上至下的堆有序化(下沉)

    /**
     * a数组
     * k下标
     * N数组的长度
     * @param a
     * @param k
     * @param N
     */
    private static void sink(int[] a,int k,int N){
        //k*2>N的时候
        while (k*2<=N){
            int j = 2*k;       //k结点的左子结点，则右子节点就是j+1;
            if (j<N && a[j]<a[j+1])j=j+1;
            if (a[k]>a[j])break;
            int temp = a[k];
            a[k] = a[j];
            a[j] = temp;
            k=j;
        }
    }

    private static void Sort(int[] a){
        int N = a.length-1;
        //先把数组a进行堆有序化，下标从最k/2开始，到k=1结束
        for (int k=N/2;k>=1;k--){
            sink(a,k,N);
        }
        //堆有序后的顺序17 15 12 13 4 5 10
        //堆排序的思路就是，
        // 在堆有序的情况下，
        // 根节点最大(本例中)，把当前的根节点与最后一个结点交换
        //此时前N-1个结点就不是堆有序了，继续去调整为堆有序
        //继续拿根节点与当前排序序列的最后一个元素交换，最后得到升序的序列
        while (N>1){
            //交换操作
            int temp = a[1];
            a[1] = a[N];
            a[N] = temp;
            N--;
            //剩余数组堆有序化
            sink(a,1,N);
        }
    }

}
