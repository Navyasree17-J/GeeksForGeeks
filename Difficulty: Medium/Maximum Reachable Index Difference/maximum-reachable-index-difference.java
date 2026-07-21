class Solution {
    public int maxIndexDifference(String s) {
        // code here
        int n = s.length();
        int start = -1;
        
        for (int x = 0; x < n; x++) {
            if (s.charAt(x) != 'a') continue;
            start = x;
            break;
        }
        
        if (start == -1) return -1;
        int looking_for = 1;
        int last_matched = -1;
        
        for (int x = start + 1; x < n; x++) {
            int data = s.charAt(x) - 'a';
            if (last_matched != -1 && data == looking_for + 1) looking_for = data;
            if (data != 0 && data <= looking_for) last_matched = x;
        }
        
        if (last_matched == -1) return 0;
        return last_matched - start;
    }
}