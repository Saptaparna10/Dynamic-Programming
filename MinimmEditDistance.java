package geeksforgeeks;

import java.util.Scanner;

public class MinimmEditDistance {
	public static void main(String[] args) {

		MinimmEditDistance ls = new MinimmEditDistance();
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int x=0;x<t;x++){
			int size1=s.nextInt();
			int size2=s.nextInt();

			String s1= s.next();
			String s2=s.next();
			System.out.println(ls.minEditDist(s1,s2, size1,size2));
		}
		s.close();


	}

	private int minEditDist(String s1, String s2, int size1, int size2) {

		char[] arr1=s1.toCharArray();
		char[] arr2=s2.toCharArray();
		int dp[][] = new int[size1+1][size2+1];

		for(int i=0; i < dp[0].length; i++){
			dp[0][i] = i;
		}

		for(int i=0; i < dp.length; i++){
			dp[i][0] = i;
		}

		for(int i=1;i<=size1;i++){
			for(int j=1;j<=size2;j++){
				if(arr1[i-1]==arr2[j-1]){
					dp[i][j]=dp[i-1][j-1];
				}
				else
					dp[i][j]=1+Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]);
			}	
		}
		return dp[size1][size2];
	}


}
