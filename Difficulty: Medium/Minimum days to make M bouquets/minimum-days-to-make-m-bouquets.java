class Solution {
    static int fun(int mid,int[] arr,int k)
    {
        int bq=0;
        int count=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<=mid)count++;
            else
            {
                bq+=(count/k);
                count=0;
            }
        }
        bq+=count/k;
        return bq;
    }
    public int minDaysBloom(int[] arr, int k, int m) {
        // code here
        if((long)m*(long)k>arr.length)return -1;
        int maxi=arr[0];
        int mini=arr[0];
        for(int x: arr){maxi=Math.max(maxi,x);mini=Math.min(mini,x);};
        int ans=maxi;
        int low=mini,high=maxi;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(fun(mid,arr,k)>=m)
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }
}