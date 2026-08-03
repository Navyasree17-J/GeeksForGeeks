class Solution {
    public int maxSumWithK(int[] arr, int k) {
        // code here
        int maxSum[]  = new int[arr.length];
        maxSum[0]= arr[0];
        int sum =arr[0];
        int i=1;
        while (i<arr.length){
            sum=Math.max(arr[i],sum+arr[i]);
            maxSum[i]=sum;
            i++;
        }
        sum=0;
        for(i=0;i<k;i++){
            sum+=arr[i];
        }
        int ans = sum;
        for(i =k;i<arr.length;i++){
            sum= sum+arr[i]-arr[i-k];
            ans=Math.max(ans,sum);
            ans=Math.max(ans,sum+maxSum[i-k]);
        }
        return ans;
    }
}