class Solution {
    public ArrayList<Integer> nextFreqGreater(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++) {
            result.add(-1);
        }
        Stack<Integer> s1 = new Stack<>();
        Map<Integer, Integer> m1 = new HashMap<>();
        for(int i=0;i<n;i++) {
            m1.put(arr[i], m1.getOrDefault(arr[i], 0) + 1);
        }
        for(int i=n-1;i>=0;i--) {
            while(!s1.isEmpty() && m1.get(arr[s1.peek()])<=m1.get(arr[i])) {
                s1.pop();
            }
            if(!s1.isEmpty()) {
                result.set(i, arr[s1.peek()]);
            }
            s1.push(i);
        }
        return result;
    }
}