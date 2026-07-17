class Solution {
    public int maxDiffSubArrays(int[] arr) {
        // code here
        int n=arr.length;
        int leftmax[]=new int[n];
        int leftmin[]=new int[n];
        int rightmin[]=new int[n];
        int rightmax[]=new int[n];
        
        int currsum1=0;
        int currsum2=0;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            currsum1+=arr[i];
            max=Math.max(max,currsum1);
            currsum2+=arr[i];
            min=Math.min(min,currsum2);
            leftmax[i]=max;
            leftmin[i]=min;
            if(currsum1<0)currsum1=0;
            if(currsum2>0)currsum2=0;
        }
        
        currsum1=0;
        currsum2=0;
        max=Integer.MIN_VALUE;
        min=Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--)
        {
            currsum1+=arr[i];
            max=Math.max(max,currsum1);
            currsum2+=arr[i];
            min=Math.min(min,currsum2);
            rightmax[i]=max;
            rightmin[i]=min;
            if(currsum1<0)currsum1=0;
            if(currsum2>0)currsum2=0;
        }
        
        int ans=0;
        for(int i=0;i<n-1;i++)
        {
            int curr=Math.max(Math.abs(leftmax[i]-rightmin[i+1]),Math.abs(leftmin[i]-rightmax[i+1]));
            ans=Math.max(ans,curr);
        }
        return ans;
    }
}