class Solution {
    private void dfs(int v, boolean[] visited, List<List<Integer>> adj) {

  visited[v] = true;

  for (int neighbor : adj.get(v)) {

   if (!visited[neighbor]) {

    dfs(neighbor, visited, adj);

   }

  }

 }
    public int findMotherVertex(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();

  for (int i = 0; i < V; i++) {

   adj.add(new ArrayList<>());

  }

  

  for (int[] edge : edges) {

   adj.get(edge[0]).add(edge[1]);

  }

  

  boolean[] visited = new boolean[V];

  int lastFinished = 0;

  

  // Step 1: Find the last finished vertex in a DFS traversal

  for (int i = 0; i < V; i++) {

   if (!visited[i]) {

    dfs(i, visited, adj);

    lastFinished = i;

   }

  }

  

  // Step 2: Reset visited array and verify the candidate

  // Optimization 2: Manual fill is slightly faster than Arrays.fill for small V,

  // but Arrays.fill is fine for general use.

  Arrays.fill(visited, false);

  dfs(lastFinished, visited, adj);

  

  // Step 3: Check if all vertices were reached

  for (boolean v : visited) {

   if (!v)

    return - 1;

  }

  

  return lastFinished;
    }
}