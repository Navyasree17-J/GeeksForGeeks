class Solution:
    class DSU:
        def __init__(self, n):
            self.parent = list(range(n))
            self.rank = [0]*n

        def find(self, x):
            if self.parent[x] != x:
                self.parent[x] = self.find(self.parent[x])
            return self.parent[x]

        def union(self, x, y):
            xr, yr = self.find(x), self.find(y)
            if xr == yr:
                return False
            if self.rank[xr] < self.rank[yr]:
                self.parent[xr] = yr
            elif self.rank[xr] > self.rank[yr]:
                self.parent[yr] = xr
            else:
                self.parent[yr] = xr
                self.rank[xr] += 1
            return True
    def secondMST(self, V, edges):
        edge_list = [(w, u, v, i) for i, (u, v, w) in enumerate(edges)]
        edge_list.sort()
        
        dsu = self.DSU(V)
        mst_weight = 0
        mst_edges = []
        in_mst = [False] * len(edges)
        
      
        for w, u, v, i in edge_list:
            if dsu.union(u, v):
                mst_weight += w
                mst_edges.append((u, v, w))
                in_mst[i] = True
                
        if len(mst_edges) != V - 1:
            return -1  
        
        second = float('inf')
        
        
        for idx, (u_rem, v_rem, w_rem) in enumerate(mst_edges):
            dsu2 = self.DSU(V)
            weight = 0
            # Add all other MST edges except the removed one
            for j, (u, v, w) in enumerate(mst_edges):
                if j == idx:
                    continue
                dsu2.union(u, v)
                weight += w
            
            for w, u, v, i in edge_list:
                if not in_mst[i] and dsu2.find(u) != dsu2.find(v):
                    weight2 = weight + w
                    if weight2 > mst_weight:
                        second = min(second, weight2)
                    break  
                
        return second if second != float('inf') else -1
        # code here
        
        
