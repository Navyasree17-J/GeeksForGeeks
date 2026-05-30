class Solution {
    public void replaceElements(int[] arr) {
        // code here
        int n = arr.length;
        int prev = arr[0];
        
        for (int i=0; i<n-1; i++) {
            int xor = prev ^ arr[i+1];
            prev = arr[i];
            arr[i] = xor;
        }
        
        arr[n-1] = prev ^ arr[n-1];
    }
}