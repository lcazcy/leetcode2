package day1_17;

/**
 * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，
 * 然后从 x 中减去该元素的值。
 *如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
 *
 * 相当于找到一个和为 sum - x 的最长连续子数组!!!!
 *
 * 滑动窗口
 */
public class Xto0_1658 {

    public static void main(String[] args) {
        int[] nums = {3,2,20,1,1,3};
        int x = 10;
        int min = minOperations(nums, x);
        if(min == -1){
            System.out.println("未找到");
        }else{
            System.out.println("最小操作数为" + min);
        }
    }

    /**
     *
     * @param nums  数组
     * @param x   要求  和
     * @return 最少操作次数
     */
    public static int minOperations(int[] nums, int x){
        int numsLength = nums.length; // 数组长度
        int left = 0;  // 滑动窗口左指针
        int right = 0;  // 滑动窗口右指针
        int maxLength = -1; // 最长连续子串长度
        int sum = 0; // 数组总和

        for(int i : nums){  // 求数组的和
            sum += i;
        }
        int count = sum - x; // 将题目转换为，要求的最长连续子序列的和
        if(count < 0){ // 数组总和小于x
            return -1;
        }
        int sumNums = 0;  // 目前连续子串总和
        while(right < numsLength){
            sumNums += nums[right];
            while(sumNums > count){   // while
                sumNums -= nums[left];
                left++;
            }
            if(sumNums == count){
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
        }
        if(maxLength == -1){
            return -1;
        }else{
            return numsLength - maxLength;
        }
    }
}
