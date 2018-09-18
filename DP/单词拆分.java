package ��̬�滮;

import java.util.List;

public class ���ʲ�� {
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
				//��ȡ��str����С�ڵ�ǰ��ȡ��i - j���ĳ��ȣ�����ǰһ�αȶԽ����true
				//���ҽ�ȡ�Ķε��ڵ�ǰ��������wordDict��
				if (str.length() <= i && dp[i-str.length()] && 
						s.substring(i - str.length(), i).equals(str)) {
					dp[i] = true;
				}
			}
		}
    	return dp[s.length()];
    }
}
