package geeksforgeeks;

import java.util.Scanner;

/* if(arr[i] > arr[j]) { T[i] = max(T[i], T[j] + 1 } */
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int x=0;x<t;x++){
			int size = s.nextInt();
			int[] arr=new int[size];
		
			for(int i=0;i<size;i++){
				arr[i]=s.nextInt();
			}
			System.out.println(lis.getMaxSeq(arr));
		}

	}

	private int getMaxSeq(int[] arr) {
		if(arr.length == 0)
			return 0;
		
        int T[] = new int[arr.length];
        int actualSolution[] = new int[arr.length];
        for(int i=0; i < arr.length; i++){
            T[i] = 1;
            actualSolution[i] = i;
        }
        
        for(int i=1; i < arr.length; i++){
            for(int j=0; j < i; j++){
                if(arr[i] > arr[j]){
                    if(T[j] + 1 > T[i]){
                        T[i] = T[j] + 1;
                        
                    }
                }
            }
        }
        
        //find the index of max number in T 
        int maxIndex = 0;
        for(int i=0; i < T.length; i++){
            if(T[i] > T[maxIndex]){
                maxIndex = i;
            }
        }
     
       return T[maxIndex];
    }

}
