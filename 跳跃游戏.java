package 动态规划;

public class 跳跃游戏 {
	public static void main(String[] args) {
		int[] arr = new int[] {2,3,1,1,4};
		canJump(arr);
	}
    public static boolean canJump(int[] nums) {
    	
    	int n = nums.length;
    	if (n == 0 || n == 1) {
			return true;
		}
    	
        boolean[] x = new boolean[n];
        x[n-1] = true;
        int truenumber = n - 1;
        
        for (int i = n-2 ; i >= 0; i--) {
			if (nums[i] >= truenumber - i) {
				x[i] = true;
				truenumber = i;
			}
		}
        return x[0];
    }
}
