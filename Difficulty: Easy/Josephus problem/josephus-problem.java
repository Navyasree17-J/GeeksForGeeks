class Solution {
    public int josephus(int n, int k) {
        // code here
        if(k == 1) return n;
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            list.add(i);
        }
        return helper(0, list, k);
    }
    private int helper(int prev, List<Integer> list, int k){
        if(list.size() == 1) return list.get(0);
        List<Integer> curr = new ArrayList<>();
        for(int i = 1; i <= list.size(); i++){
            prev++;
            if(prev == k){
                prev = 0;
                continue;
            }
            else{
                curr.add(list.get(i-1));
            }
        }
        return helper(prev, curr, k);
    }
}