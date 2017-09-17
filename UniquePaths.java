package leetCode;

import java.util.Scanner;

public class UniquePaths {

	public static void main(String[] args) {

		UniquePaths up = new UniquePaths();
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		System.out.println(up.countPaths(m,n));
		s.close();
	}

	private int countPaths(int m, int n) {/*
		
		int[][] dp = new int[m][n];
		for(int i=0;i<n;i++){
			dp[0][i]=1;
		}
		for(int j=0;j<m;j++){
			dp[j][0]=1;
		}
		
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				System.out.print(dp[i][j]);
			}
			System.out.println();
		}
		return dp[m-1][n-1];
	*/
		 //https://www.youtube.com/watch?v=M8BYckxI8_U
		 int N = n + m - 2;// how much steps we need to do
         int k = m - 1; // number of steps that need to go down
         double res = 1;
         // here we calculate the total possible path number 
         // Combination(N, k) = n! / (k!(n - k)!)
         // reduce the numerator and denominator and get
         // C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
         for (int i = 1; i <= k; i++)
             res = res * (N - k + i) / i;
         return (int)res;
     }

}
