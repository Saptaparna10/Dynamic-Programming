package geeksforgeeks;

import java.util.Scanner;

public class NumberOfWaysToReachAScore {


	public static void main(String[] args) {


		NumberOfWaysToReachAScore ls = new NumberOfWaysToReachAScore();
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int x=0;x<t;x++){
			int total=s.nextInt();
			int[] scores = {3,5,10};

			System.out.println(ls.ways(scores,total));
		}
		s.close();
	}

	private int ways(int[] score,int total) {
		int T[] = new int[total+1];
		T[0] = 1;
		for(int i=0; i < score.length; i++){
			for(int j=1; j <= total; j++){
				if(score[i] <= j){
					T[j] += T[j-score[i]];
				}
			}
		}
		return T[total];}

}
