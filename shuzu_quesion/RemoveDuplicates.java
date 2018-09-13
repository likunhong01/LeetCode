package 数组;


import java.util.Arrays;

public class RemoveDuplicates {
	
	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
        int n = 0;
        for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i+1] != nums[i]) {
				n++;
				nums[n] = nums[i+1];
			}
		}
		return n + 1;
    }
	
	public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int tmp = nums[0];
        int i = 0;
        for (int j = 0; j < k; j++) {
        	for (i = 1; i < n; i++) {
            	int a = nums[i];
            	nums[i] = tmp;
            	tmp = a;
    		}
        	nums[0] = tmp;
		}
    }
	
	public static boolean containsDuplicate(int[] nums) {
		Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {

			if (dichotomie(nums, nums[i] , i) != -1) {
				return true;
			}
		}
		return false;
    }
	
	public static int dichotomie(int[] nums, int k, int i) {
		int head = 0;
		int end = nums.length - 1;
		int middle;
		while (head < end) {
			middle = (head + end) /2;
			if (nums[middle] == k && middle != i) {
				return middle;
			}
			if (nums[middle] > k) {
				end = middle - 1;
				continue;
			}
			else {
				head = middle + 1;
				continue;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		int[] arr = new int[] {1,2,3,4};
		System.out.println(containsDuplicate(arr));
		
		
//		int[] arr = new int[] {1,2,3,4,5,6,7};
//		rotate(arr, 6);
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + " ");
//		}
		
		
//		int[] arr = new int[] {1,1};
//		int n = removeDuplicates(arr);
//		
//		for (int i = 0; i < n; i++) {
//			System.out.print(arr[i] + " ");
//			
//		}
//		System.out.println();
//		System.out.println(n);
	}

}
