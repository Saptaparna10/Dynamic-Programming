package geeksforgeeks;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumLengthChainofPairs {
	static class Pair implements Comparable<Pair>{
        public Pair(int a,int b){
            this.a = a;
            this.b = b;
        }
        int a;
        int b;
        @Override
        public int compareTo(Pair o) {
            if(this.a <= o.a){
                return -1;
            }else{
                return 1;
            }
        }
    }
    
    public int maxLength(Pair[] arr){
        Arrays.sort(arr);
        
        int T[] = new int[arr.length+1];
        for(int i=0; i < T.length; i++){
            T[i] = 1;
        }
        for(int i=2; i < T.length; i++){
            for(int j=1; j < i; j++){
                if(arr[j-1].b < arr[i-1].a){
                    T[i] = Math.max(T[j] + 1, T[i]);
                }
            }
        }
        
        int max =0 ;
        for(int i=1; i <T.length; i++){
            if(max < T[i]){
                max = T[i];
            }
        }
        return max;
    }
    
	public static void main(String args[]){
		MaximumLengthChainofPairs lps = new MaximumLengthChainofPairs();
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int x=0;x<t;x++){
			int size = s.nextInt();
			Pair[] arr = new Pair[size];
			for(int i=0;i<size;i++){
				Pair p = new Pair(s.nextInt(), s.nextInt());
				arr[i]=p;
			}
			System.out.println(lps.maxLength(arr));
		}
	}
}
