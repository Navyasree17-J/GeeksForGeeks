class Solution {
    public int catchThieves(char[] arr, int k) {
        // code here
        Stack<Integer> st1=new Stack<>();
        Stack<Integer> st2=new Stack<>();
        int f=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]=='P')
            st1.push(i);
            else
            st2.push(i);
            
        }
        while(!st1.isEmpty()&&!st2.isEmpty())
        {
            if(Math.abs(st1.peek()-st2.peek())<=k)
            {
                st1.pop();
                st2.pop();
                f++;
            }
            else if(st2.peek()<st1.peek())
            {
                st1.pop();
            }
            else
            st2.pop();
            
        }
        return f;
    }
}