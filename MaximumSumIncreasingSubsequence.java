package geeksforgeeks;

import java.util.Scanner;

public class MaximumSumIncreasingSubsequence {


	public static void main(String[] args) {
		
		MaximumSumIncreasingSubsequence lis = new MaximumSumIncreasingSubsequence();
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

	private int getMaxSeq(int[] arr) {
		
		int dp[] = new int[arr.length];
		
		for(int y=0;y<arr.length;y++){
			dp[y]=arr[y];
		}

		for(int i=1;i<arr.length;i++){
			for(int j=0;j<i;j++){
				if(arr[j]<arr[i]){
					dp[i]=Math.max(dp[j]+arr[i],dp[i]);
				}
			}
		}
		
		int max=0;
		for(int z=0;z<dp.length;z++){
			if(dp[z]>dp[max]){
				max=z;
			}
		}
		return dp[max];
	}


}
