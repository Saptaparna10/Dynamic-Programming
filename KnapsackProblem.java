package geeksforgeeks;

import java.util.Scanner;

public class KnapsackProblem {


	public static void main(String[] args) {
		KnapsackProblem ls = new KnapsackProblem();
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int x=0;x<t;x++){
			int numberOfItems=s.nextInt();
			int maxCapa=s.nextInt();

			int[] values = new int[numberOfItems];
			int[] weights = new int[numberOfItems];

			for(int y=0;y<numberOfItems;y++){
				values[y]=s.nextInt();
			}
			for(int y=0;y<numberOfItems;y++){
				weights[y]=s.nextInt();
			}
			System.out.println(ls.maxValue(values,weights,maxCapa));
		}
		s.close();

	}

	private int maxValue(int[] values, int[] weights, int maxCapa) {
		
		int dp[][] = new int[values.length+1][maxCapa+1];
		
		for(int a=0;a<=values.length;a++){
			for(int b=0;b<=maxCapa;b++){
				 if(a == 0 || b == 0){
	                    dp[a][b] = 0;
	                    continue;
	                }
				if(b>=weights[a-1]){
					dp[a][b]=Math.max(dp[a-1][b], values[a-1]+dp[a-1][b-weights[a-1]]);
				}
				else
					dp[a][b]=dp[a-1][b];
			}
			
		}
		return dp[weights.length][maxCapa];
	}


}
