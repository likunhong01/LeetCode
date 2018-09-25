package 动态规划;

public class 最长上升子序列的长度 {
	public static void main(String[] args) {
		int[] arr = new int[] {1,7,8,6,9,2};
		System.out.println(lengthOfLIS(arr));
	}
    public static int lengthOfLIS(int[] nums) {
    	if (nums.length == 0) {
			return 0;
		}
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 0;
        for (int i = 1; i < dp.length; i++) {
        	int x = 0;
			for (int j = 0; j < i; j++) {
				if (nums[j] <= nums[i]) {
					x = Math.max(dp[j], x) ;
				}
			}
			dp[i] = x + 1;
			result = Math.max(dp[i], result);
		}
        return result;
    }
}
