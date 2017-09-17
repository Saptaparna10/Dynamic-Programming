package geeksforgeeks;

import java.util.Scanner;

public class MinimumNumberofJumps {


	public static void main(String[] args) {
		MinimumNumberofJumps ls = new MinimumNumberofJumps();
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int x=0;x<t;x++){
			int size=s.nextInt();
			int[] input = new int[size];
			
			for(int i=0;i<size;i++){
				input[i]=s.nextInt();
			}
			System.out.println(ls.findMinJumps(size,input));
		}
		s.close();
	}

	private int findMinJumps(int size, int[] input) {
		
		int[] dp = new int[size];
		
		dp[0]=0;
		for(int i=1;i<size;i++){
			dp[i]=Integer.MAX_VALUE-1;
		}
		
		for(int i=1;i<size;i++){
			for(int j=0;j<i;j++){
				if(i<=j+input[j]){
					dp[i]=Math.min(dp[i], dp[j]+1);
				}
			}
		}
		if(dp[size-1]==Integer.MAX_VALUE-1)
			return -1;
		else
			return dp[size-1];
	}




}
