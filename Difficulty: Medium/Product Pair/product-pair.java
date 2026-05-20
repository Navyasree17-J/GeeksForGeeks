class Solution {
    public boolean isProduct(int[] arr, long target) {
        // code here
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        
        while(left < right) {
            long prod = (long) arr[left] * arr[right];
            
            if(prod == target) {
                left++;
                right--;
                return true;
            }
            else if(prod < target) {
                left++;
            }
            else {
                right--;
            }
        }
        return false;
    }
}