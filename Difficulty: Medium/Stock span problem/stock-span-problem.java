class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        ArrayList<Integer> ansList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int j = 0;
        while(j < n){
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[j]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ansList.add(j+1);
            }else{
                ansList.add(j-stack.peek());
            }
            stack.push(j);
            j++;
        }
        return ansList;
    }
}