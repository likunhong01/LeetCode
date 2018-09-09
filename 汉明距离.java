package 初级数学;

public class 汉明距离 {
	public static void main(String[] args) {
//		System.out.println(hammingDistance(1, 4));
		System.out.println(reverseBits(2));
	}
	
	
	public static int reverseBits(int n) {
        String b = Integer.toBinaryString(n);
        int x = b.length();
        for (int i = 0; i < 32 - x; i++) {
			b = "0" + b;
		}
        StringBuffer buffer = new StringBuffer(b);
        buffer = buffer.reverse();
        int sum = 0;
        for (int i = 0; i < 32; i++) {
			if (buffer.charAt(31-i) == '1') {
				sum += Math.pow(2, i);
			}
		}
        return sum;
    }
	
	public int hammingWeight(int n) {
		String string = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == '1') {
				count++;
			}			
		}
        return count;
    }
	
	
    public static int hammingDistance(int x, int y) {
        int z = x ^ y;
        String string = Integer.toBinaryString(z);
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == '1') {
				count++;
			}			
		}
        return count;
    }
}
