package 数组;

import java.util.Arrays;

public class 只出现一次的数字 {
	public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i+=2) {
			if (nums[i] == nums[i+1]) {
				continue;
			}
			return nums[i];
		}
        return nums[nums.length - 1];
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = new int[] {4,1,2,1,2};
		System.out.println(singleNumber(arr));
	}

}
