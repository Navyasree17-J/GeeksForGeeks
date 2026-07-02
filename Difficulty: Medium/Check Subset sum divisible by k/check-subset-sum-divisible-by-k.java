class Solution {
    public boolean divisibleByK(int[] arr, int k) {
        // code here
        //int n = arr.length;
        Boolean [][] dp = new Boolean[arr.length+1][k];
        return solve(0,arr,k,0,false,dp);
    }
    boolean solve(int i,int[] arr,int k,int s,boolean taken,Boolean[][] dp){
        
        if(i == arr.length ) return taken && s == 0;
        if(taken && dp[i][s] != null ) return dp[i][s];
        return dp[i][s] =  solve(i+1,arr,k,(s+arr[i])%k,true,dp) || solve(i+1,arr,k,s,taken,dp);
    }
}