package 动态规划;

public class 买股票的最大价值含冷冻期 {
    public int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE, pre_buy = 0, sell = 0, pre_sell = 0;
         for (int price : prices) {
             pre_buy = buy;
             buy = Math.max(pre_sell - price, pre_buy);
             pre_sell = sell;
             sell = Math.max(pre_buy + price, pre_sell);
         }
         return sell;
    }
}
