package geeksforgeeks;

import java.util.Scanner;

public class PartitionProblem {
	public static void main(String args[]){
		PartitionProblem lps = new PartitionProblem();
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int x=0;x<t;x++){
			int size = s.nextInt();
			Integer input[] = new Integer[size];
			for(int i = 0; i < input.length; i++){
				input[i]=s.nextInt();
			}
			System.out.println(lps.calculate(input,size));
		}
	}

	private String calculate(Integer[] input, int size) {
		int sum=0;
		for (int i = 0; i < input.length; i++) {
			sum += input[i];
		}
		if(sum%2!=0){
			return "NO";
		}
		else{
			sum=sum/2;
			Boolean dp[][] = new Boolean[size][sum+1];
			
			for (int a=0; a<size; a++){
				dp[a][0]=true;
			}
			for (int b=1; b<=sum; b++){
				if(input[0]== b){
					dp[0][b]=true;
				}
				else
					dp[0][b]=false;
			}
				
			
			for (int i = 1; i < input.length; i++) {
				for (int j = 1; j <= sum; j++){
					if(j<input[i]){
						dp[i][j]=dp[i-1][j];
					}
					else{
						dp[i][j]=dp[i-1][j] || dp[i-1][j-input[i]];
					}
						
				}
				

			}
			if(dp[size-1][sum]){
				return "YES";
			}
			else
				return "NO";
		}

	}
}