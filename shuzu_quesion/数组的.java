package 数组;

import java.util.HashMap;

public class 数组的 {
	public static void main(String[] args) {
		char[][] arr = new char[][]{
		{'5','3','.','.','7','.','.','.','.'},
		{'6','.','.','1','9','5','.','.','.'},
		{'.','9','8','.','.','.','.','6','.'},
		{'8','.','.','.','6','.','.','.','3'},
		{'4','.','.','8','.','3','.','.','1'},
		{'7','.','.','.','2','.','.','.','6'},
		{'.','6','.','.','.','.','2','8','.'},
		{'.','.','.','4','1','9','.','.','5'},
		{'.','.','.','.','8','.','.','7','9'},
		};
		System.out.println(isValidSudoku(arr));
		
		
//		int[][] arr= new int[][] {
//		{ 5, 1, 9,11},
//		{ 2, 4, 8,10},
//		{13, 3, 6, 7},
//		{15,14,12,16}
//		};
//		rotate(arr);
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr.length; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
	}
	
	public static boolean checkRowCol(char[][] board) {
		int n = board.length;
		HashMap<Character, Character> check = new HashMap<Character, Character>();
		
		//检查行
        for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == '.') {
					continue;
				}
				if (check.containsKey(board[i][j])) {
					return false;
				}
				else {
					check.put(board[i][j], board[i][j]);
				}
			}
			check.clear();
		}
        
        //检查列
        for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[j][i] == '.') {
					continue;
				}
				if (check.containsKey(board[j][i])) {
					return false;
				}
				else {
					check.put(board[j][i], board[j][i]);
				}
			}
			check.clear();
		}
        return true;
	}
	
	public static boolean isValidSudoku(char[][] board) {
		int n = board.length;
		int small = 3;
		if (!checkRowCol(board)) {
			return false;
		}
        
		char[][] check = new char[3][3];
        //检查3×3块
		HashMap<Character, Character> check1 = new HashMap<Character, Character>();
		HashMap<Character, Character> check2 = new HashMap<Character, Character>();
		HashMap<Character, Character> check3 = new HashMap<Character, Character>();
        for(int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		if (board[i][j] == '.') {
					continue;
				}
        		if (j < 3) {
        			
        			if (check1.containsKey(board[i][j])) {
						return false;
					}
					check1.put(board[i][j], board[i][j]);
				}else if (j < 6) {
					if (check2.containsKey(board[i][j])) {
						return false;
					}
					check2.put(board[i][j], board[i][j]);
				}else {
					if (check3.containsKey(board[i][j])) {
						return false;
					}
					check3.put(board[i][j], board[i][j]);
				}
			}
        	if (i % 3 == 2) {
				check1.clear();
				check2.clear();
				check3.clear();
			}
        }
        return true;
    }
	
	
	
	
	public static void rotate(int[][] matrix) {
        int n = matrix.length;
		for(int i = 0; i < n/2 ; i++) {
			for (int j = i; j < n - i - 1; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[n-1-j][i];
				matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
				matrix[j][n-1-i] = tmp;
			}
		}
    }
	
	
	public int[] twoSum(int[] numbers, int target) {
		int [] res = new int[2];
	    if(numbers==null||numbers.length<2)
            return res;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < numbers.length; i++){
	        if(!map.containsKey(target-numbers[i])){
	            map.put(numbers[i],i);
	        }else{
	            res[0]= map.get(target-numbers[i]);
	            res[1]= i;
	            break;
	        }
	    }
	    return res;
    }
}
