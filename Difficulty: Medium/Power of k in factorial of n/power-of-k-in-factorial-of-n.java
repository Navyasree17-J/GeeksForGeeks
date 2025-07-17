class Solution {
    public int maxKPower(int n, int k) {
        // code here
        Map<Integer, Integer> primeFactors = primeFactorization(k);
        int minPower = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : primeFactors.entrySet()) {
            int prime = entry.getKey();
            int exponentInK = entry.getValue();
            int exponentInNFact = legendre(n, prime);
            minPower = Math.min(minPower, exponentInNFact / exponentInK);
        }

        return minPower;
        
    }
    public static Map<Integer, Integer> primeFactorization(int k) {
        Map<Integer, Integer> primeFactors = new HashMap<>();
        for (int i = 2; i * i <= k; i++) {
            while (k % i == 0) {
                primeFactors.put(i, primeFactors.getOrDefault(i, 0) + 1);
                k /= i;
            }
        }
        if (k > 1) {
            primeFactors.put(k, 1);
        }
        return primeFactors;
    }
     public static int legendre(int n, int p) {
        int count = 0;
        while (n > 0) {
            n /= p;
            count += n;
        }
        return count;
    }
}