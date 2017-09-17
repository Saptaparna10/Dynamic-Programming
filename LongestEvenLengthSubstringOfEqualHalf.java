package geeksforgeeks;

import java.util.Scanner;

public class LongestEvenLengthSubstringOfEqualHalf {

	public static void main(String[] args) {

		LongestEvenLengthSubstringOfEqualHalf ls = new LongestEvenLengthSubstringOfEqualHalf();
		
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int x=0;x<t;x++){
			String str=s.next();
			int[] input = new int[str.length()];
			for (int count = 0; count < str.length(); ++count)
				   input[count] = str.charAt(count)-'0';
			
			System.out.println(ls.findMaxLen(input));
		}
		s.close();
		
	}

	private int findMaxLen(int[] input) {
		
		int dp[][]=new int[input.length][input.length];
		
		for(int i=0; i < dp.length; i++){
            dp[i][i] = input[i];
        }
		
		 int max = 0;
	        for(int len = 2; len <= input.length; len++){
	            for(int i=0; i < input.length - len+1; i++){
	                int j = i + len-1;
	                //updating sum for each lenght
	                dp[i][j] = dp[i][j-1] + input[j];
	                
	                if(len % 2 == 0){
	                    int k = (i + j)/2;
	                    if(dp[i][k] == dp[k+1][j]){
	                        if(max < len){
	                            max = len;
	                        }
	                    }
	                }
	            }
	        }
	        return max;
	}
}
