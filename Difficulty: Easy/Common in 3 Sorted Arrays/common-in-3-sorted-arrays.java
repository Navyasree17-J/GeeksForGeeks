class Solution {
    public ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        
        int i=0;
        int j=0;
        int k=0;
        
        
        while(i<a.length && j<b.length && k<c.length){
            if(a[i]==b[j] && b[j]==c[k]){
                if((ans.size()>0 && ans.get(ans.size()-1)!= a[i] ) || ans.size()==0) ans.add(a[i]);
                i++;
                j++;
                k++;
                    
            } 
            if(i>=a.length || j>=b.length || k>=c.length) break;
            int max=Math.max(a[i],Math.max(b[j],c[k]));
            
            while(i<a.length && a[i]<max) i++;
            while(j<b.length && b[j]<max) j++;
            while(k<c.length && c[k]<max) k++;
            
            
        }
        
        return ans;
    }
}