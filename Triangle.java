package leetCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Triangle {
	public static void main(String args[]){
		Triangle t = new Triangle();
		List<List<Integer>> tr = new ArrayList<List<Integer>>();
		
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(2);
		tr.add(l1);
		
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(3);
		l2.add(4);
		tr.add(l2);

		List<Integer> l3 = new ArrayList<Integer>();
		l2.add(6);
		l2.add(5);
		l2.add(7);
		tr.add(l3);


		t.minimumTotal(tr);
	}
	public int minimumTotal(List<List<Integer>> triangle) {
	    int[] A = new int[triangle.size()+1];
	    for(int i=triangle.size()-1;i>=0;i--){
	        for(int j=0;j<triangle.get(i).size();j++){
	            A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
	        }
	    }
	    return A[0];
	}
}
