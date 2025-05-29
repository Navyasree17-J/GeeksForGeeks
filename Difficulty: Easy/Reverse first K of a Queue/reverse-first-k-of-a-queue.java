class Solution {
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        // code here
        if(q == null || k<= 0 || k > q.size()){
            return q;
        }
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < k; i++){
            st.push(q.poll());
        }
        while(!st.isEmpty()){
            q.add(st.pop());
        }
        int size = q.size();
        for(int i = 0; i < size-k; i++){
            q.add(q.poll());
        }
        return q;
    }
}