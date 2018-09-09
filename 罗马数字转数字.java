package 初级数学;

public class 罗马数字转数字 {
	public static void main(String[] args) {
		System.out.println(romanToInt("LVIII"));
	}
    public static int romanToInt(String s) {
        int[] a = new int[256];
        a['I'] = 1;  
        a['V'] = 5;  
        a['X'] = 10;  
        a['C'] = 100;  
        a['M'] = 1000;  
        a['L'] = 50;  
        a['D'] = 500; 
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
        	//如果是最后一个字符，或者前一个大于后面的，就加，否则减
			if (i == s.length() - 1 || a[s.charAt(i+1)] <= a[s.charAt(i)]) {
				val += a[s.charAt(i)];
			}else {
				val -= a[s.charAt(i)];
			}
		}
        return val;
    }
}
