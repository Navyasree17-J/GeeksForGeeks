class Solution {
    private int powerMod(int a, int b) {
        int res = 1;
        a %= 10;

        while (b > 0) {
            if ((b & 1) == 1)
                res = (res * a) % 10;

            a = (a * a) % 10;
            b >>= 1;
        }

        return res;
    }
    public int getLastDigit(String a, String b) {
        // code here
        if (b.equals("0"))
            return 1;

        int base = a.charAt(a.length() - 1) - '0';

        int result = 1;

        for (char ch : b.toCharArray()) {
            int digit = ch - '0';

            result = powerMod(result, 10);
            result = (result * powerMod(base, digit)) % 10;
        }

        return result;
    }
};