package Offer;

/**
 * @Author: meteor @Date: 2018/8/30 08:52
 * 输入一个整数数组，
 * 判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true，否则返回false。
 * 假设输入的数组的任意两个数字都互不相同:
 *
 * 写出判断是否为后序遍历的基础逻辑，（先找到根节点）
 * 然后去递归的判断左右子树
 */
public class No24 {

    /**
     * 参数为输入的整数数组，数组的开始下标和终止下标
     * @param a
     * @param start
     *
     * @return
     */
    private static boolean isLastOrder(int[] a,int start,int end){

        //入参判断
        if (a == null || start<0 || start>end || end >a.length){
            return false;
        }
        if (start == end)
            return true;
        //根节点
        int root = a[end];

        //判断左子树
        int i = start;
        for (;i<=end;i++){
            //如果大于根节点，则退出循环，此时的i值为右子树的起始节点
            if (a[i]>root)
                break;
        }

        //判断右子树
        int j=i;
        for (;j<=end-1;j++){
            //如果右子树的值小于根节点，则返回false
            if (a[j]<root)
                return false;
        }

        //递归判断左子树
        boolean left = true;
        if (i>start){
            left = isLastOrder(a,start,i-1);
        }

        boolean right = true;
        if (i<end){
            right = isLastOrder(a,i,end-1);
        }
        //左子树和右子树同时符合要求，返回两者的与
        return (left&&right);
    }


    public static void main(String[] args){
        //int[] a = {5,7,6,9,11,10,8};
        //int[] a = {7,4,6,5};
        //boolean result = isLastOrder(a,0,3);
        //System.out.println(result);
    }
}
