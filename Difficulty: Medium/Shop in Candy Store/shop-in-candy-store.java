class Solution {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        // code here
         int min=0,max=0,i=0,j=prices.length-1;
        Arrays.sort(prices);
        while(i<=j){
            min+=prices[i];
            j-=k;
            i++;
        }
        i=0;
        j=prices.length-1;
        while(i<=j){
            max+=prices[j];
            i+=k;
            j--;
        }
        ArrayList<Integer> res=new ArrayList<>();
        res.add(min);
        res.add(max);
        return res;
    }
}
