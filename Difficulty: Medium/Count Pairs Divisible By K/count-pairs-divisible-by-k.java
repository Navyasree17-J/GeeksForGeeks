class Solution {
    public int countKdivPairs(int[] arr, int k) {
        // code here
         int[] rem=new int[k];
        for(int i:arr)rem[i%k]+=1;
        int i=1,j=k-1,ans=(rem[0] * (rem[0] - 1)) / 2;;
        while(i<=j) ans+=(i==j)?((rem[i++]*(rem[j--]-1))/2):(rem[i++]*rem[j--]);
        return ans; 
    }
}