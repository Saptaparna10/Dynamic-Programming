package geeksforgeeks;

import java.util.Scanner;

public class CoinChange {

	public static void main(String[] args) {


		CoinChange ls = new CoinChange();
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int x=0;x<t;x++){
			int numberOfCoins=s.nextInt();
			int sum=s.nextInt();
			int[] coins = new int[numberOfCoins];

			for(int y=0;y<numberOfCoins;y++){
				coins[y]=s.nextInt();
			}
			System.out.println(ls.minChange(coins,sum));
		}
		s.close();
	}

	private int minChange(int[] coins,int sum) {
		
		int[] dp = new int[sum+1];
		int[] track = new int[sum+1];
		int temp=Integer.MAX_VALUE-1;
		
		dp[0]=0;
		for(int x=1;x<dp.length;x++)
			dp[x]=temp;
		for(int y=0;y<track.length;y++)
			track[y]=-1;
		
		for(int j=0;j<coins.length;j++){
			for(int i=1;i<sum+1;i++){
				if(i>=coins[j]){
					dp[i]= Math.min(dp[i],1+dp[i-coins[j]]);
					track[i]=j;
				}
				
			}
				
		}
		if(dp[dp.length-1]==temp)
			return -1;
		else
		return dp[dp.length-1];
	}
}
