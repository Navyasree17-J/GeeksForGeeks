class Solution {
    public int minTime(int[] ranks, int n) {
        // code here
        int minRank = Integer.MAX_VALUE;
        for (int r : ranks) minRank = Math.min(minRank, r);

        long low = 0;

        long high = (long)minRank * n * (n + 1L) / 2L;
        long ans = high;

        while (low <= high) {
            long mid = (low + high) / 2;
            if (canMake(ranks, n, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int)ans;
    }

    private boolean canMake(int[] ranks, int need, long T) {
        long total = 0;
        for (int r : ranks) {
          
          
            double disc = 1.0 + (8.0 * T) / r;
            long k = (long)((Math.sqrt(disc) - 1.0) / 2.0);


            while (k > 0 && (long)r * k * (k + 1L) / 2L > T) k--;
            while ((long)r * (k + 1L) * (k + 2L) / 2L <= T) k++;

            total += k;
            if (total >= need) return true;
        }
        return total >= need;
    }
}