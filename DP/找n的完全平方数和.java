package 动态规划;

import java.util.ArrayList;
import java.util.List;

public class 找n的完全平方数和 {
	public static void main(String[] args) {
		System.out.println(numSquares(7));
	}
    public static int numSquares(int n) {
    	if (n == 0) {
			return 0;
		}
        List<Integer> dp = new ArrayList<>();
        int tmp = n;
        for (int i = 0; i < n; i++) {
			int x = (int)Math.sqrt(tmp);
			dp.add(x);
			tmp = tmp - x * x;
			if (tmp == 0) {
				break;
			}
		}
        return dp.size();
    }
}
