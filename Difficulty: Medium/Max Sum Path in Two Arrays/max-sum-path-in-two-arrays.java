class Solution {
    public int maxPathSum(int[] a, int[] b) {
        // code here
        int n = a.length, m = b.length;
        
        int i = 0, j = 0;
        int sumA = 0, sumB = 0, maxSum = 0;
        
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                sumA += a[i];
                i++;
            }
            else if (a[i] > b[j]) {
                sumB += b[j];
                j++;
            }
            else {
                sumA += a[i++];
                sumB += b[j++];
                
                maxSum += Math.max(sumA, sumB);
                sumA = sumB = 0;
            }
        }
        
        while (i < n) {
            sumA += a[i++];
        }
        
        while (j < m) {
            sumB += b[j++];
        }
        
        maxSum += Math.max(sumA, sumB);
        return maxSum;
    }
}