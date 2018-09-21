package 动态规划;

import java.util.Arrays;

public class 零钱兑换 {
	
	public static void main(String[] args) {
		int[] coins = new int[] {186,419,83,408};
		System.out.println(coinChange(coins, 6249));
	}
	
	public static int coinChange1(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = Integer.MIN_VALUE;
		}
		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j <= amount; j++) {
				dp[j] = Math.min(dp[i], dp[j-coins[i]] + 1);
			}
		}
		return dp[amount] < 0 ? -1 : dp[amount];
	}
	
    public static int coinChange(int[] coins, int amount) {
    	Arrays.sort(coins);
    	int n = coins.length;
        int[][] res = new int[n+1][amount+1];
        //数组行为每个面值，列为需要凑价值为0-amount的钱
        
        for (int i = 0; i < res[0].length; i++) {
			res[0][i] = Integer.MIN_VALUE;
		}
        for (int i = 0; i < res.length; i++) {
			res[i][0] = 0;
		}
        
        
        for (int i = 1; i < n+1; i++) {
        	//i表示当前面值在coins里的第几个面值
			for (int j = 1; j < amount+1; j++) {
				//res[i][j]表示当前是要用前i个面额凑总金额为j元的个数
				
				//如果能整除当前循环到的最大的面值
				if (j % coins[i-1] == 0) {
					res[i][j] = j / coins[i-1];
					continue;
				}
				
				//先赋值上一轮的硬币数量
				res[i][j] = res[i-1][j];
				
				//当前循环到的面值为nn
				int nn = coins[i-1];
				
				//tmp为根据前面的配置，看能不能通过加上这次加入的最大面额减少硬币数量
				//j/nn为先用最大面额配置，res[i-1][j%nn]是上一个最大面额对多余还没配的钱配出的数量
				int x = j/nn;
				int tmp = res[i][x*nn] + res[i - 1][j - x*nn];
				while (tmp <= 0 && x > 1) {
					x--;
					tmp = res[i][x * nn] + res[i - 1][j - x*nn];
				}
				//如果配出来是负数代表多余的金额没法配置，
				//所以要么等于上一个最大面额配出的硬币数量
				//要么无法配置
				if (tmp < 0) {
					continue;
				}else {
					if (res[i][j] > 0) {
						res[i][j] = Math.min(tmp, res[i][j]);
					}else {
						res[i][j] = tmp;
					}
					
				}
			}
		}
        if (res[n][amount] < 0) {
			return -1;
		}
        return res[n][amount];
    }
}
