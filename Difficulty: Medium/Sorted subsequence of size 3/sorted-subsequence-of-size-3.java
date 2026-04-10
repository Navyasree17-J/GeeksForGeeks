class Solution {
    public ArrayList<Integer> find3Numbers(int[] arr) {
        // code here
        ArrayList<Integer>  al  = new ArrayList<Integer> ();
        int n = arr.length;
        if(n<3) return al;
        int i=0,j=1,k=2;
        while(i<j && j<k && k<n){
            if(arr[i]<arr[j] && arr[j]<arr[k]){
                al.add(arr[i]);
                al.add(arr[j]);
                al.add(arr[k]);
                break;//as found 
            }
            if(arr[k]<arr[j] && k<n-1) {
                k++;
                continue;
            }
            if((arr[j]<arr[i] && j<k && j<n-2) || (k==n-1 && j<k-1)){
                j++;
                k=j+1;
                continue;
            }
            else{
                i++;
                j=i+1;
                k=j+1;
            }
        }
        return al;
    }
}