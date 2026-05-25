class Solution {
    public boolean checkElements(int start, int end, int[] arr) {
        // code here
        HashSet<Integer> vol = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            vol.add(arr[i]);
        }
        
        int i = start;
        while(i<=end){
            if(!vol.contains(i)){
                return false;
            }
            i++;
        }
        
        return true;
    }
}