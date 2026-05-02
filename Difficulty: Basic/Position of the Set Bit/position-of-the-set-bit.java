class Solution {
    public int findPosition(int n) {
        // code here
        double value = (Math.log10(n) / Math.log10(2));
        if(value - (int)value > 1e-4) return -1;
        return (int)value + 1;
    }
}