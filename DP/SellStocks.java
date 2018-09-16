package 动态规划;

public class SellStocks {

	public int maxProfit(int[] prices) {
		int[] maxMoney = new int[prices.length];
		int max = 0;
		
		for (int i = 1; i < maxMoney.length; i++) {
			maxMoney[i] = maxMoney[i - 1] + prices[i] - prices[i - 1];
			System.out.print(maxMoney[i - 1] + " ");
			
			if (maxMoney[i] < 0) {
				maxMoney[i] = 0;
			}
			max = Math.max(max, maxMoney[i]);
		}
		System.out.println(maxMoney[maxMoney.length - 1] + " ");
		return max;
	}
	
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] a = new int[] {2,3,1,3,1};
		SellStocks aSellStocks = new SellStocks();
		System.out.println(aSellStocks.maxProfit(a));
	}

}
