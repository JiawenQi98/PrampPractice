/**
 * Created by qijiawen on 8/14/17.
 */
public class NumberOfPaths {

    // DP method: Time O(n^2), Space O(n)
    static int numOfPathsToDest (int n) {
        // base case
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j != 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[n-1];
    }

    public static void main (String[] args) {
        int n1 = 4;
        int n2 = 40;
        System.out.println("Number of ways of n = " + n1 + " is: "+ numOfPathsToDest(n1));
        System.out.println("Number of ways of n = " + n2 + " is: "+ numOfPathsToDest(n2));
    }
}
