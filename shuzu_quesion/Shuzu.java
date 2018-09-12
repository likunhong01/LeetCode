package 数组;

public class Shuzu {

	public static int maxProfit(int[] prices) {
		int min = 0;
		int maxPrice = 0;
		boolean a = false;
		for (int i = 0; i < prices.length - 1; i++) {
			if (!a) {
				min = prices[i];
			}
			if (prices[i + 1] > prices[i] ) {
				a = true;
				if (i == prices.length - 2) {
					maxPrice += prices[i + 1] - min;
				}
				continue;
			}
			else {
				a = false;
				maxPrice += prices[i] - min;
			}
		}
		return maxPrice;
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = new int[] {1,2,3,4,5};
		System.out.println(maxProfit(arr));
	}

}
