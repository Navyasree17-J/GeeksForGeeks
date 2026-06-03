class Solution {
    public ArrayList<Integer> freqInRange(int[] arr, int[][] queries) {
        // code here
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
       ArrayList<Integer> ans = new ArrayList<>();
       int len = arr.length;
       for(int i=0; i<len; i++)
       {
           int val = arr[i];
           if(!map.containsKey(val))map.put(val , new ArrayList<>());
           map.get(val).add(i);
       }
    //   System.out.println(map);
       
       for(int[] querie : queries)
       {
           int l = querie[0];
           int r = querie[1];
           int x = querie[2];
           int a = lowerBS(map.get(x) , l);
           int b = upperBS(map.get(x) , r);
        //   System.out.println(a+" "+b);
           ans.add(b-a);
       }
       return ans;
    }
    private int lowerBS(ArrayList<Integer> al , int val){
        
        int n = al==null ?0: al.size();
        int i =0 , j=n-1;
        while(i <= j){
            int mid = (i + (j-i)/2);
            
            if(al.get(mid) < val){
                i = mid+1;
            }
            else{
                j = mid - 1;
            }
        }
        return i;
    }
     private int upperBS(ArrayList<Integer> al , int val){
        
        int n = al==null ?0: al.size();
        int i =0 , j=n-1;
        while(i <= j){
            int mid = (i + (j-i)/2);
            
            if(al.get(mid) <= val){
                i = mid+1;
            }
            else{
                j = mid - 1;
            }
        }
        return i;
    }
}