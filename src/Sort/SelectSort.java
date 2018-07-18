package Sort;

/**
 * @Author: meteor @Date: 2018/7/18 19:08
 * 选择排序的思想是：1.在未排序的数组中选择最小值放在数组的起始，
 * 依次遍历剩余数组的最小值，继续1的步骤
 *
 */
public class SelectSort{

    public static void selectSort(int[] nums) {

        int len = nums.length;

        for(int i=0;i<len-1;i++){
            int min = i;                //最小值的索引；初始值为0；
            //内层循环是为了寻找数组中的最小值
            for(int j=i+1;j<len;j++){
                if(nums[j] < nums[min]){
                    min = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
    }

    public static void main(String[] args) {

        int[] nums = {4,5,7,2,3,8,9};
        selectSort(nums);
        for(int i=0;i<nums.length;i++)
            System.out.print(nums[i]);
    }
}
