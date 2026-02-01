class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();

        Deque<Integer> dq = new ArrayDeque<>();

 

        for (int i = 0; i < arr.length; i++) {

 

            // Remove elements out of window

            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {

                dq.pollFirst();

            }

 

            // Remove small elements

            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {

                dq.pollLast();

            }

 

            dq.offerLast(i);

 

            // Add max for current window

            if (i >= k - 1) {

                result.add(arr[dq.peekFirst()]);

            }

        }

        return result;
    }
}