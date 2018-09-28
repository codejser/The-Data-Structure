package Sort;

/**
 * @Author: meteor @Date: 2018/7/18 18:50
 * 冒泡排序：n-1趟：每一趟比较相邻的数字，最终将数组的最大值放到左端(右端)；
 * 外层循环控制趟数：n-1;
 * 内层循环控制每一趟比较的次数：
 * 每一趟都会固定一个数，在下一趟中不参与比较，所以每一趟的比较次数是n-i;i代表趟数;
 */
public class BubbleSort {
    public static void bubbleSort(int[] nums){
        int len = nums.length;

        for(int i=0; i<len-1;i++){
            for(int j=0;j<len-1-i;j++){
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
