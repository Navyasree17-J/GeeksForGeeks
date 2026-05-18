class Solution {
    public int maxSum(int n) {
        // code here.
         if(n==0) return 0;
        
        int n1 = maxSum(n/2);
        int n2 = maxSum(n/3);
        int n3 = maxSum(n/4);
        
        int sum = n1+n2+n3;
        return Math.max(sum, n);
    }
}
