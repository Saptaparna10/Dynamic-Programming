package geeksforgeeks;

import java.util.Scanner;

public class PalindromePartitioning {


	public static void main(String args[]){
		PalindromePartitioning lps = new PalindromePartitioning();
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int x=0;x<t;x++){
			String str = s.next();
			int r2 = lps.calculate1(str);
			System.out.println(r2);
		}
	}

	public int calculate1(String str1){
		char[] str = str1.toCharArray();
		int count=0;
		int T[][] = new int[str.length][str.length];
		for(int i=0; i < str.length; i++){
			T[i][i] = 0;
			count++;
		}
		
		for(int l = 2; l <= str.length; l++){
			for(int i = 0; i < str.length-l + 1; i++){
				int j = i + l - 1;
				if(isPalindrome(str1, i, j)){
					T[i][j] = 0;
					count++;
				}
				/*else if(l==2 && !isPalindrome(str1, i, j)){
                	T[i][j] = 1;
                }*/
				else {
					T[i][j] = Integer.MAX_VALUE;
					for(int k=i;k<=j-1;k++)
						T[i][j] = Math.min(T[i][j],1+ T[i][k]+T[k+1][j]);
				}
			}
		}
		
		return T[0][str.length-1];
		//return count; -- for number of pallindromes
	}

	private  boolean isPalindrome(String str, int r, int t) {
		while(r < t) {
			if (str.charAt(r) != str.charAt(t)) {
				return false;
			}
			r++;
			t--;
		}
		return true;
	}
}
