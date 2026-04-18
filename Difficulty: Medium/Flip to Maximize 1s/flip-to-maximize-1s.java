class Solution {
    int maxOnes(int[] arr) {
        // code here
         int cnt=0,total=0,ans=0;

        for(int i=0;i<arr.length;i++){

            if(cnt<=0)

            cnt=0;

            if(arr[i]==1){

                cnt--;

                total++;

            }

            if(arr[i]==0)

            cnt++;

            ans=Math.max(ans,cnt);

        }

       return total+ans;
    }
};