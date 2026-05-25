class Solution {
    int min (int a, int b) {
        return a < b ? a : b;
    }
    public int coin(int[] arr) {
        // code here
        int m = Integer.MAX_VALUE;
        for (int x: arr) m = min(m, x);
        return m;
    }
}