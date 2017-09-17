package leetCode;

import java.util.Scanner;

public class MinPathSum {

	public static void main(String[] args) {

		MinPathSum up = new MinPathSum();
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();

		int[][] arr = new int[m][n];

		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				arr[i][j]= s.nextInt();
			}
		}

		System.out.println(up.minPathSum(arr));
		s.close();
	}

	public int minPathSum(int[][] grid) {
		
		int row = grid.length;
		int col = grid[0].length;
		
		int dp[][] = new int[row][col];
		
		dp[0][0] = grid[0][0];
		
		for(int i = 1; i < col; i++){
			dp[0][i]= grid[0][i]+dp[0][i-1];
		}
		
		for(int j = 1; j < row; j++){
			dp[j][0]= grid[j][0]+dp[j-1][0];
		}
		
		for(int i = 1; i < row; i++){
			for(int j = 1; j < col; j++){
	
					dp[i][j] = grid[i][j] +  Math.min(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		return dp[row-1][col-1];
	}
}
