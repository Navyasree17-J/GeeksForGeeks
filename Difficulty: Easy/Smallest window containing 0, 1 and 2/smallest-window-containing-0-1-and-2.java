class Solution {
    public int smallestSubstring(String s) {
        // code here
          int n = s.length();
        HashMap<Character,Integer> hm = new HashMap<>();
        String res = "102";
        for(char ch:s.toCharArray()){
            hm.put(ch,1);
        }
        int l = 0;
        int r = 0;
        int cnt = 0;
        int miniLen = Integer.MAX_VALUE;
        while(r<n){
            if(hm.containsKey(s.charAt(r))){
                if(hm.get(s.charAt(r))>0) cnt++;
                hm.put(s.charAt(r),hm.getOrDefault(s.charAt(r),0)-1);
                
            }
            while(cnt == 3){
                if((r-l+1)<miniLen){
                    miniLen = r-l+1;
                }
            if(hm.containsKey(s.charAt(l))){
                hm.put(s.charAt(l),hm.getOrDefault(s.charAt(l),0)+1);
                if(hm.get(s.charAt(l))>0)  cnt--;
            }
            l++;
        }
        r++;
        }
    return (miniLen == Integer.MAX_VALUE)?-1:miniLen;
    }
};
