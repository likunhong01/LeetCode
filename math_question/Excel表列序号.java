package 数学问题;

public class Excel表列序号 {
	public static void main(String[] args) {
		System.out.println(titleToNumber("AAB"));
	}
    public static int titleToNumber(String s) {
    	int length = s.length();
    	
        if (length == 1) {
			return s.charAt(0) - 'A' + 1;
		}
        
        else {
        	StringBuffer sB = new StringBuffer(s);
        	sB.deleteCharAt(0);
			return (int)(s.charAt(0) - 'A' + 1) * (int)Math.pow(26, length - 1) + titleToNumber(sB.toString());
		}
    }
}
