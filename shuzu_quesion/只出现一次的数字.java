package ����;

import java.util.Arrays;

public class ֻ����һ�ε����� {
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
		// TODO �Զ����ɵķ������
		int[] arr = new int[] {4,1,2,1,2};
		System.out.println(singleNumber(arr));
	}

}
