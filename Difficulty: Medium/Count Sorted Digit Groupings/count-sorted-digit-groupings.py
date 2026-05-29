class Solution:
    def validGroups(self, s):
        # code here
        def f(ind, val):
            if ind >= n:
                return 1
            if (ind,val) in dp:
                return dp[(ind,val)]
            cnt, curr = 0,0
            for i in range(ind, n):  
                curr += int(s[i])
                v = int(curr)
                if v >= val:
                    cnt += f(i + 1, v)
            dp[(ind,val)] = cnt
            return cnt

        n = len(s)
        dp = {}
        return f(0, 0)
 