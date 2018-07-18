package Sort;

/**
 * @Author: meteor @Date: 2018/7/18 20:06
 * 直接插入排序：默认第一个数为已排序，将未排序的数组插入到已经排序的数组当中，交换法则
 */
public class InsertSort {

    public static void insertSort(int[] nums){

        int len = nums.length;

        for(int i=1;i<len;i++){
            int j = i;
            while (j>0 && nums[j] <nums[j-1]){
                int temp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = {4,5,7,2,3,8,9};
        insertSort(nums);
        for(int i=0;i<nums.length;i++)
            System.out.print(nums[i]);
    }
}
