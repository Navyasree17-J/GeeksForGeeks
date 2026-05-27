class Solution {
    public boolean wifiRange(String s, int x) {
        // code here
        int n = s.length();
    
        int[] diffArr = new int[n];
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == '1'){
                diffArr[Math.max(0 , i - x)] += 1;
                if(i + x + 1 < n){
                    diffArr[i + x + 1] -= 1;
                }
            }
        }
        //cummulative sum
        for(int i = 1 ; i < n ; i++){
            diffArr[i] += diffArr[i-1];
        }
        for(int i = 0 ; i < n ; i++){
            if(diffArr[i] == 0) return false;
        }
        
        return true;
    }
}