class Solution {
    public int countPartitions(int[] arr, int d) {
        int sum = 0;
        int n = arr.length;

        for (int num : arr) {
            sum += num;
        }

        // If (sum + d) is odd, we cannot split into two valid subsets
        if ((sum + d) % 2 != 0) {
            return 0;
        }

        int s1 = (d + sum) / 2;

        // DP array to count subsets with sum s1
        int[][] dp = new int[n + 1][s1 + 1];

        // Base case: There's always one way to get sum 0 (empty subset)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Base case: There's no way to form positive sum with zero elements
        for (int j = 1; j <= s1; j++) {
            dp[0][j] = 0;
        }

        // Fill DP table
        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j <s1+1; j++) { // j starts from 0
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][s1];
    }
}