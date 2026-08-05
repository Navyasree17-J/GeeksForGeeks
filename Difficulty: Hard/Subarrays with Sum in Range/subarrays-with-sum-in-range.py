class Solution:
    def countSubarray(self, arr: list[int], l: int, r: int) -> int:
        # code here
        from bisect import bisect_left, bisect_right
        
        acc = [0]
        s, ans = 0, 0
        for e in arr:
            s += e 
            small = s-r
            big = s-l
            i = bisect_left(acc, small)
            j = bisect_right(acc, big)
            ans += j-i
            acc.append(s)
        return ans