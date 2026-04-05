class Solution {
    public int totalWays(int[] arr, int target) {
        // code here
         int total=0;

        for(int num:arr)

        total+=num;

        if(Math.abs(target)>total) return 0;

        if((total+target)%2!=0) return 0;

        int req=(target+total)/2;

        int[]dp=new int[req+1];

        dp[0]=1;

        for(int num:arr){

        for(int sum=req;sum>=num;sum--){

            dp[sum]+=dp[sum-num];

        }

        }

        

       return dp[req];
    }
}