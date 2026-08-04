class Solution:
    def countPairs(self, arr: list[int], k: int) -> int:
        # code here
        n = len(arr)
        if n == 1:
            return 0
            
        arr.sort()
        
        count = 0
        
        i,j = 0, 1
        
        while i < n:
            if arr[j] - arr[i] < k:
                if j < n - 1:
                    j += 1
                else:
                    count += (j - i)
                    i += 1
            else:
                count += (j - i - 1)
                i += 1
                
        return count