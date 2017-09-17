package leetCode;

import java.util.Scanner;

public class UniquePaths2 {

	public static void main(String[] args) {

		UniquePaths2 up = new UniquePaths2();
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		int[][] arr = new int[m][n];
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				arr[i][j]= s.nextInt();
			}
		}
		
		System.out.println(up.uniquePathsWithObstacles(arr));
		s.close();
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	    int width = obstacleGrid[0].length;
	    int[] dp = new int[width];
	    dp[0] = 1;
	    for (int[] row : obstacleGrid) {
	        for (int j = 0; j < width; j++) {
	            if (row[j] == 1)
	                dp[j] = 0;
	            else if (j > 0)
	                dp[j] += dp[j - 1];
	        }
	    }
	    return dp[width - 1];
	}

}
