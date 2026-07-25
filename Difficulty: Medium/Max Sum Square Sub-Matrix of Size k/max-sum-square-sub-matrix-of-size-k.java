class Solution {
    int max (int a, int b) {
        return a > b ? a : b;
    }
    public int maximumSum(int[][] mat, int k) {
        // code here
        int n = mat.length;
        int m = n + 1;
        int[][] mem = new int[m][m];
        
        int max = Integer.MIN_VALUE;
        
        for (int x = 1; x < m; x++) {
            for (int y = 1; y < m; y++) {
                mem[x][y] = 
                    mem[x][y-1] + 
                    mem[x-1][y] - 
                    mem[x-1][y-1] +
                    mat[x-1][y-1];
                if (y >= k && x >= k) {
                    max = max(
                        max, 
                        mem[x][y] -
                        mem[x][y-k] -
                        mem[x-k][y] + 
                        mem[x-k][y-k]
                    );
                }
            }
        }
        
        return max;
    }
}