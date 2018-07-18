package Sort;

/**
 * @Author: meteor @Date: 2018/7/18 18:50
 * 冒泡排序：n-1趟：每一趟需要排序相邻的元素；每一趟结束后较大值都会排到右端
 *
 */
public class BubbleSort {
    public static void bubbleSort(int[] nums){
        int len = nums.length;

        for(int i=0; i<len-1;i++){
            for(int j=0;j<len-1;j++){
                if (nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {

        int[] nums = {4,5,7,2,3,8,9};
        bubbleSort(nums);
        for(int i=0;i<nums.length;i++)
            System.out.print(nums[i]);
    }
}
