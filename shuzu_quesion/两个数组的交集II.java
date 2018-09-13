package ����;


import java.util.Arrays;
import java.util.LinkedList;

public class ��������Ľ���II {
	public static void moveZeroes(int[] nums) {
		int count = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] != 0) {
        		if (i != count) {
    				int tmp = nums[i];
    				nums[i] = nums[count];
    				nums[count] = tmp;
    			}
				count++;
			}
			
		}
    }
	public static int[] plusOne(int[] digits) {
		int n = digits.length;
		int[] arr = new int[n + 1];
		int i = 0;
		//��ǰn-1�����ƹ���,��arr����һ��λ��
		for (i = 0; i < n; i++) {
			arr[i+1] = digits[i];
		}
		//��n��++
		arr[i] = ++digits[i-1];
		//�����n������9,��arr���飬
		if (arr[i] > 9) {
			//����1-length-1�Ľ�λ���յĵ�һ��������λ
			for (int j = arr.length - 1; j > 0 ; j--) {
				if (arr[j] > 9) {
					arr[j] %= 10;
					arr[j-1] += 1;
				}
			}
			//�����һ����0����ʾû�н�����һλ
			if (arr[0] == 0) {
				//ȫ��ǰ��һ��λ
				int[] x = new int[n];
				for (int j = 0; j < x.length; j++) {
					x[j] = arr[j+1];
				}
				return x;
			}
			return arr;
		}
		//���nС��9����������+1
		else {
			return digits;
		}
    }
	
	public static int[] intersect(int[] nums1, int[] nums2) {
		if (nums1.length == 0 || nums2.length == 0) {
			return new int[0];
		}
		LinkedList<Integer> a = new LinkedList();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
		
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] == nums2[j]) {
				a.add(nums1[i]);
				i++;
				j++;
				continue;
			}
			if (nums1[i] < nums2[j]) {
				i++;
				continue;
			}
			if (nums1[i] > nums2[j]) {
				j++;
				continue;
			}
		}
		int[] answer = new int[a.size()];
		for (int k = 0; k < answer.length; k++) {
			answer[k] = a.poll();
		}
		return answer;
    }
	
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] a1 = new int[] {0,0,0,0,0,0,0,0,0,1};
//		int[] a2 = new int[] {1,1};
//		int[] a3 = intersect(a1, a2);
//		for (int i = 0; i < a3.length; i++) {
//			System.out.print(a3[i]+" ");
//		}
		
		
//		int[] a = plusOne(a1);
//		for (int i = 0; i < a.length; i++) {
//			System.out.println(a[i]);
//		}
		
		
		moveZeroes(a1);
		for (int i = 0; i < a1.length; i++) {
			System.out.print(a1[i]+" ");
		}
	}

}
