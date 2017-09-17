package leetCode;

import java.util.Scanner;

import geeksforgeeks.LongestIncreasingSubsequence;

public class NumberOfLIS {


	public static void main(String[] args) {

		NumberOfLIS lis = new NumberOfLIS();
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int x=0;x<t;x++){
			int size = s.nextInt();
			int[] arr=new int[size];

			for(int i=0;i<size;i++){
				arr[i]=s.nextInt();
			}
			System.out.println(lis.getMaxSeq(arr));
		}

	}

	private int getMaxSeq(int[] nums) 
	{
		int n = nums.length, res = 0, max_len = 0;
		int[] len =  new int[n], cnt = new int[n];
		for(int i = 0; i<n; i++){
			len[i] = cnt[i] = 1;
			for(int j = 0; j <i ; j++){
				if(nums[i] > nums[j]){
					if(len[i] == len[j] + 1)cnt[i] += cnt[j];
					if(len[i] < len[j] + 1){
						len[i] = len[j] + 1;
						cnt[i] = cnt[j];
					}
				}
			}
			if(max_len == len[i])res += cnt[i];
			if(max_len < len[i]){
				max_len = len[i];
				res = cnt[i];
			}
		}
		return res;
	}


}
