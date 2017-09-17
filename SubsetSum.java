package geeksforgeeks;

import java.util.Scanner;

public class SubsetSum {

	public String subsetSum(int input[], int total) {

		if((total%2)!=0){
			return "NO";
		}
		else
			total = total/2;
		
        boolean T[][] = new boolean[input.length + 1][total + 1];
        for (int i = 0; i <= input.length; i++) {
            T[i][0] = true;
        }

        for (int i = 1; i <= input.length; i++) {
            for (int j = 1; j <= total; j++) {
                if (j - input[i - 1] >= 0) {
                    T[i][j] = T[i - 1][j] || T[i - 1][j - input[i - 1]];
                } else {
                    T[i][j] = T[i-1][j];
                }
            }
        }
        if(T[input.length][total])
        	return "YES";
        else
        	return "NO";

    }
	public static void main(String args[]) {
		SubsetSum ss = new SubsetSum();
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for(int i=0;i<t;i++){
			int size = s.nextInt();
			int input[]=new int[size];
			
			int sum=0;
			for(int j=0;j<size;j++){
				input[j]=s.nextInt();
				sum=sum+input[j];
			}
			System.out.println(ss.subsetSum(input, sum));
		}

	}
}
