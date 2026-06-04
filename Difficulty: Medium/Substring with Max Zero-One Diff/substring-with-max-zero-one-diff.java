class Solution {
    int maxSubstring(String s) {
        // code here
        int zero = 0;
        int one = 0;
        int ans = -1;
        
        for(char ch: s.toCharArray()) {
            if(ch == '0') {
                zero++;
            }
            else {
                one++;
            }
            
            int total = zero - one;
            ans = Math.max(ans, total);
            
            // Not required
            if(total < 0) {
                zero = 0;
                one = 0;
            }
        }
        
        return ans;
    }
}