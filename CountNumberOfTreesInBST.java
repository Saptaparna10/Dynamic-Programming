package geeksforgeeks;

public class CountNumberOfTreesInBST {
	public static void main(String args[]){
        CountNumberOfTreesInBST cnt = new CountNumberOfTreesInBST();
        System.out.println(cnt.countTrees(3));
        System.out.println(cnt.countTrees(5));
    }

	private int countTrees(int n) {
		
		int dp[] = new int[n+1];
		dp[0]=1;
		dp[1]=1;
		for(int i=2;i<=n;i++){
			for(int j=0;j<i;j++){
				dp[i] += dp[j]*dp[i-j-1];
			}
		}
		return dp[n];
	}
}
