class Solution {
    public int findIndex(String s) {
        // code here
        return (int) s.chars()
                      .filter(ch -> ch == ')')
                      .count();
    }
}