package geeksforgeeks;

import java.util.Scanner;

public class MatrixMultiplicationCost {
	public int findCost(int arr[]){
        int temp[][] = new int[arr.length][arr.length];
        int q = 0;
        for(int l=2; l < arr.length; l++){
            for(int i=1; i < arr.length - l + 1; i++){
                int j = i + l - 1;
                temp[i][j] = Integer.MAX_VALUE-1;
                for(int k=i; k <= j-1; k++){
                    q = temp[i][k] + temp[k+1][j] + arr[i-1]*arr[k]*arr[j];
                    if(q < temp[i][j]){
                        temp[i][j] = q;
                    }
                }
            }
        }
        return temp[1][arr.length-1];
    }
    
    public static void main(String args[]){
        MatrixMultiplicationCost mmc = new MatrixMultiplicationCost();
        //int arr[] = {2,3,6,4,5};
        Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int x=0;x<t;x++){
			int size=s.nextInt();
			
			int arr[]=new int[size];
			for(int i=0;i<size;i++){
				arr[i]=s.nextInt();
			}
			System.out.println(mmc.findCost(arr));
		}
		s.close();

    }
}
