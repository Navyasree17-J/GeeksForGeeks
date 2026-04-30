class Solution {
    public boolean isMaxHeap(int[] arr) {
        // code here
        for(int i=arr.length-1;i>=1;i--)

        if(arr[i]>arr[(i-1)/2])

            return false;

    return true;
    }
}