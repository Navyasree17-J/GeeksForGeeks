class Solution {
    public boolean canRepresentBST(List<Integer> arr) {
        // code here
        int n=arr.size();
        Stack<Integer>st=new Stack<>();
        int limit=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            int num=arr.get(i);
            if(num<limit)return false;
            while(!st.isEmpty() && num>st.peek())
            {
                limit=st.pop();
            }
            st.push(num);
        }
        return true;
    }
}