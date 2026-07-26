class Solution {
    public ArrayList<ArrayList<Integer>> levelSort(int[] arr) {
        // code here
        int n = arr.length;
        
        int height = (int)(Math.log(n) / Math.log(2));
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        int nodeCnt = 1;
        int idx = 0;
        
        for(int level = 0 ; level <= height ; level++){
            int tempCnt = nodeCnt;
            ArrayList<Integer> levelList = new ArrayList<>();
            while(idx < n && tempCnt-- > 0){
                levelList.add(arr[idx]);
                idx++;
            }
            Collections.sort(levelList);
            result.add(levelList);
            if(idx == n) break;
            nodeCnt *= 2;
        }
        
        return result;
    }
}