class Solution {
    int[] printKClosest(int[] arr, int k, int x) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> {
                int diffA = Math.abs(a - x);
                int diffB = Math.abs(b - x);
                if (diffA != diffB) {
                    return diffB - diffA;
                } else {
                    return a - b; 
                }
            }
        );

        for (int num : arr) {
            if (num != x) {
                pq.add(num);
            }
            if (pq.size() > k) {
                pq.poll(); 
            }
        }

         int[] ans = new int[k];
        int index = k - 1;
        while (!pq.isEmpty()) {
            ans[index--] = pq.poll();
        }

        return ans;
    }
}
