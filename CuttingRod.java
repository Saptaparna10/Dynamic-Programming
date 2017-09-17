package geeksforgeeks;

import java.util.Scanner;

public class CuttingRod {

	public static void main(String[] args) {
		CuttingRod cr =new CuttingRod();
		int[] price = {3,5,8,9,10,20,22,25};
		int r = cr.maxValue1(price);
		System.out.println(r);

	}


	public int maxValue1(int price[]){
		int max[] = new int[price.length+1];
		for(int i=1; i <= price.length; i++){
			max[i] = price[i-1];
		}
		for(int i=1 ; i <= price.length; i++){
			for(int j=1; j < i ; j++){
				max[i] = Math.max(max[i], max[i-j] + max[j]);
			}
		}
		return max[price.length];
	}
}