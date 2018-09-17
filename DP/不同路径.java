package 动态规划;

public class 不同路径 {
	public static void main(String[] args) {
//		System.out.println(uniquePaths(3, 2));
	    try {
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    } catch (ClassNotFoundException e) {
	        System.err.println("未找到驱动");
	    }
	    System.out.println("数据库驱动成功");
	}
    public static int uniquePaths(int m, int n) {
        int[][] mn = new int[m][n];
        
        mn[0][0] = 1;
        if (m == 1 && n == 1) {
			return mn[0][0];
		}
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				//mn[i][j]等于左边加上面过来的路径
				if (i - 1 >= 0 && j - 1 >= 0) {
					mn[i][j] = mn[i-1][j] + mn[i][j-1];
				}else {
					if (i-1 < 0) {
						mn[i][j] = mn[i][j-1];
					}
					if (j-1 < 0) {
						mn[i][j] = mn[i-1][j];
					}
				}
			}
		}
        return mn[m-1][n-1];
    }
}
