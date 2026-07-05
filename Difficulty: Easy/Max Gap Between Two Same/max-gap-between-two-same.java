class Solution {
    public int maxCharGap(String s) {
        // code here
        int[] firstIndex = new int[26];

        // Initialize all positions with -1 to indicate they haven't been seen yet

        Arrays.fill(firstIndex, -1);

        

        int maxGap = -1;

        int n = s.length();

        

        for (int i = 0; i < n; i++) {

            int charIndex = s.charAt(i) - 'a';

            

            if (firstIndex[charIndex] == -1) {

                // First time seeing this character, record its position

                firstIndex[charIndex] = i;

            } else {

                // Character seen before, calculate the gap and update maxGap

                int currentGap = i - firstIndex[charIndex] - 1;

                if (currentGap > maxGap) {

                    maxGap = currentGap;

                }

            }

        }

        

        return maxGap;
    }
};