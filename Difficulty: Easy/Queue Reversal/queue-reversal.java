class Solution {
    // Function to reverse the queue.
    public Queue<Integer> reverseQueue(Queue<Integer> queue) {
        // code here.
        Stack<Integer> stack = new Stack<>();
        
        while(!queue.isEmpty()){
            stack.push(queue.poll());
        }
        
        while(!stack.isEmpty()){
            queue.offer(stack.pop());
        }
        return queue;
    }
}