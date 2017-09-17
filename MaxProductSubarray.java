package leetCode;

import java.util.Scanner;

public class MaxProductSubarray {

	public static void main(String[] args) {
		MaxProductSubarray mps = new MaxProductSubarray();
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		
		for(int i=0;i<size;i++){
			arr[i]=s.nextInt();
		}
		System.out.println(mps.calculateMaxProduct(arr));
	}

	private int calculateMaxProduct(int[] nums) {
		
		int dp[] = new int[nums.length];
				
		int[] f = new int[nums.length];
	    int[] g = new int[nums.length];
	    
		f[0] = nums[0];
		g[0] = nums[0];
		int res = nums[0];
		
		for(int i=1;i<nums.length;i++){
				f[i]=Math.max(nums[i], Math.max(nums[i]*f[i-1], nums[i]*g[i-1]));
				g[i]=Math.min(nums[i], Math.min(nums[i]*f[i-1], nums[i]*g[i-1]));
				res = Math.max(res, f[i]);

		}
		return res;
	}

}
