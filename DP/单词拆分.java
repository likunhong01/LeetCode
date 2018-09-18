package 动态规划;

import java.util.List;

public class 单词拆分 {
	public static void main(String[] args) {
		String s = "abc";
		System.out.println();
	}
    public boolean wordBreak(String s, List<String> wordDict) {
        
    	boolean[] dp = new boolean[s.length() + 1];
    	dp[0] = true;
    	for (int i = 1; i < dp.length; i++) {
			dp[i] = false;			
		}
    	
    	for (int i = 1; i <= s.length(); i++) {
    		for (int j = 0; j < wordDict.size(); j++) {
				String str = wordDict.get(j);
				//获取的str长度小于当前截取（i - j）的长度，并且前一段比对结果是true
				//并且截取的段等于当前遍历到的wordDict段
				if (str.length() <= i && dp[i-str.length()] && 
						s.substring(i - str.length(), i).equals(str)) {
					dp[i] = true;
				}
			}
		}
    	return dp[s.length()];
    }
}
