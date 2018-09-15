package 动态规划;

public class MaxSubArray {
	
	public static int maxSubArray(int[] nums) {
		
		int length = nums.length;
        if(length==0){
            return 0;
        }
        int sum = nums[0];
        int b = 0;
        for(int i=0;i<length;i++){
            if(b>0){
                b += nums[i];
            }else{
                b = nums[i];
            }
            if(sum<b){
                sum = b;
            }
        }
        return sum;
	}
	
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = new int[] {-4, -2 ,-8 ,-9 ,-1,-5};
		System.out.println(maxSubArray(arr));
	}

}
