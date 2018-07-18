package LeetCode;

/**
 * @Author: meteor @Date: 2018/7/18 14:01
 */
public class Lcode27 {

    /**
     * 删除nums数组中的val值,并返回剩余的数组大小
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n){
            if(nums[i] == val){
                n--;
                nums[i] = nums[n];
            }else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] test = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(test,0));
    }




}
