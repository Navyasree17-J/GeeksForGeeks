class Solution {
    public int substrCount(String s, int k) {
        // code here
        HashSet<Character> set = new HashSet<>();
        
        int l=0,r=0;
        int ans = 0;
        while(r<s.length()){
            if(r-l == k){
                if(set.size()==k-1)
                    ans++;
                set.remove(s.charAt(l));
                l++;
                for(int i=l;i<r;i++)
                    set.add(s.charAt(i));
            }
            set.add(s.charAt(r));
            r++;
        }
        if(r - l ==k && set.size() == k-1)
            ans++;
        
        return ans;
    }
}