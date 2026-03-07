class Solution {
    static int noOfWays(int m, int n, int x) {
        // code here
         int[][]dp= new int[n+1][x+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=x;j++)
            {
                dp[i][j]=-1;
            }
        }
        solveMem(n,m,x,dp);
        
        return dp[n][x];
    }
    
    public static int solveMem(int dice,int faces,int target,int [][]dp)
    {
        if(target<0)
        return 0;
        if(target==0&&dice!=0)
        return 0;
        if(target!=0&&dice==0)
        return 0;
        if(target==0&&dice==0)
        return 1;
        
        if(dp[dice][target]!=-1)
        return dp[dice][target];
        int ans=0;
        //These are the choices we are having....
        for(int i=1;i<=faces;i++)
        {
            // we are reducing the taget and number of dice used...
            //rercusion is taking care all the things...
           ans+=solveMem(dice-1,faces,target-i,dp); 
        }
        return dp[dice][target]=ans;
    }
};