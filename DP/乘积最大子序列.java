package 动态规划;

public class 乘积最大子序列 {
	public static void main(String[] args) {
		int[] arr = new int[] {-2,-3,-1,6};
		System.out.println(maxProduct(arr));
	}
    public static int maxProduct(int[] nums) {
    	if (nums == null || nums.length == 0)  return 0; 
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
        	int product=1;
        	for(int j=i;j<n;j++){
        		product=product*nums[j];
        		if(product>max){
        			max=product;
        		}
        	}
        }
        return max;
//        int n = nums.length;
//        
//        int dp[] = new int[n];
//        int max = nums[0];
//        int min = nums[0];
//        int result = nums[0];
//        for (int i = 1; i < dp.length; i++) {
//			int tmp = max;
//			max = Math.max(Math.max(nums[i], max * nums[i]), min * nums[i]);
//			min = Math.min(Math.min(nums[i], tmp * nums[i]), min * nums[i]);
//			result = Math.max(result, max);
//        }
//        
//        return result;
    }
}
