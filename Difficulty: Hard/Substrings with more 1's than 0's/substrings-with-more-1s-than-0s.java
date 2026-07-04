class Solution {
    private void update(int[] bit, int idx, int val) {
        for (; idx < bit.length; idx += idx & -idx) {
            bit[idx] += val;
        }
    }

    private int query(int[] bit, int idx) {
        int sum = 0;
        for (; idx > 0; idx -= idx & -idx) {
            sum += bit[idx];
        }
        return sum;
    }
    public int countSubstring(String s) {
        // code here
        int n = s.length();
        
        // The prefix sum can range from -n to n.
        // To avoid negative indices, we add an offset of (n + 1).
        // Size of BIT needs to accommodate up to 2 * n + 2.
        int offset = n + 1;
        int[] bit = new int[2 * n + 3];
        
        int currentSum = 0;
        int totalSubstrings = 0;
        
        // Initialize the BIT with the initial prefix sum of 0 (at index 0 + offset)
        update(bit, 0 + offset, 1);
        
        for (int i = 0; i < n; i++) {
            // Update the running prefix sum
            if (s.charAt(i) == '1') {
                currentSum += 1;
            } else {
                currentSum -= 1;
            }
            
            // We need to count all previous prefix sums that are strictly less than currentSum.
            // In the BIT, this corresponds to querying the range [1, (currentSum + offset) - 1]
            totalSubstrings += query(bit, currentSum + offset - 1);
            
            // Add the current prefix sum to the BIT
            update(bit, currentSum + offset, 1);
        }
        
        return totalSubstrings;
    }
}