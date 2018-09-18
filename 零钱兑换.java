package ��̬�滮;

import java.util.Arrays;

public class ��Ǯ�һ� {
	
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
        //������Ϊÿ����ֵ����Ϊ��Ҫ�ռ�ֵΪ0-amount��Ǯ
        
        for (int i = 0; i < res[0].length; i++) {
			res[0][i] = Integer.MIN_VALUE;
		}
        for (int i = 0; i < res.length; i++) {
			res[i][0] = 0;
		}
        
        
        for (int i = 1; i < n+1; i++) {
        	//i��ʾ��ǰ��ֵ��coins��ĵڼ�����ֵ
			for (int j = 1; j < amount+1; j++) {
				//res[i][j]��ʾ��ǰ��Ҫ��ǰi�������ܽ��ΪjԪ�ĸ���
				
				//�����������ǰѭ������������ֵ
				if (j % coins[i-1] == 0) {
					res[i][j] = j / coins[i-1];
					continue;
				}
				
				//�ȸ�ֵ��һ�ֵ�Ӳ������
				res[i][j] = res[i-1][j];
				
				//��ǰѭ��������ֵΪnn
				int nn = coins[i-1];
				
				//tmpΪ����ǰ������ã����ܲ���ͨ��������μ�������������Ӳ������
				//j/nnΪ�������������ã�res[i-1][j%nn]����һ��������Զ��໹û���Ǯ���������
				int x = j/nn;
				int tmp = res[i][x*nn] + res[i - 1][j - x*nn];
				while (tmp <= 0 && x > 1) {
					x--;
					tmp = res[i][x * nn] + res[i - 1][j - x*nn];
				}
				//���������Ǹ����������Ľ��û�����ã�
				//����Ҫô������һ�������������Ӳ������
				//Ҫô�޷�����
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
