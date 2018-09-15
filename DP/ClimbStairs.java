package 动态规划;

public class ClimbStairs {

	public int climb(int n) {
		int[] a = new int[n + 1];
		a[0] = 0;
		if (n > 0) {
			a[1] = 1;
		}
		if (n > 1) {
			a[2] = 2;
		}
		if (n >= 3) {
			for (int i = 3; i < a.length; i++) {
				a[i] = a[i - 1] + a[i - 2];
			}
		}
		return a[n];
	}
	
	
	public int minCostClimbingStairs(int[] cost) {
		int n = cost.length;
		int[] f = new int[n];
		f[0] = cost[0];
		if (n>0) {
			f[1] = cost[1];
		}
		if (n>1) {
			for (int i = 2; i < f.length; i++) {
				f[i] = cost[i] + Math.min(f[i-1], f[i-2]);
			}
		}
		return Math.min(f[n-1], f[n-2]);
	}
	
	
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		ClimbStairs climbStairs = new ClimbStairs();
//		System.out.println(climbStairs.climb(4));
		int[] cost = new int[] {1,1,0,0};
		System.out.println(climbStairs.minCostClimbingStairs(cost));
	}

}
