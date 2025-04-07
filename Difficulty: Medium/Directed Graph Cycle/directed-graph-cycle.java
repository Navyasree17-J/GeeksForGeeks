//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.isCyclic(V, edges);
            System.out.println(ans ? "true" : "false");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        int[][] adj = new int[V][V];
        
        // Build the adjacency matrix from the edges
        for (int[] edge : edges) {
            adj[edge[0]][edge[1]] = 1;
        }
        
        // Arrays to track visited nodes and nodes in the current recursion stack
        boolean[] visited = new boolean[V];
        boolean[] inStack = new boolean[V];
        
        // Perform DFS for each vertex
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, inStack)) {
                    return true; // Cycle detected
                }
            }
        }
        
        return false; // No cycle found
    }

    // Helper function to perform DFS and detect cycles
    private boolean dfs(int node, int[][] adj, boolean[] visited, boolean[] inStack) {
        // If the node is in the recursion stack, we found a cycle
        if (inStack[node]) {
            return true;
        }
        
        // If the node is already visited, no cycle
        if (visited[node]) {
            return false;
        }

        // Mark the node as visited and part of the recursion stack
        visited[node] = true;
        inStack[node] = true;

        // Explore all neighbors
        for (int i = 0; i < adj.length; i++) {
            if (adj[node][i] == 1) { // If there's an edge from 'node' to 'i'
                if (dfs(i, adj, visited, inStack)) {
                    return true;
                }
            }
        }

        // Backtrack: remove the node from the recursion stack
        inStack[node] = false;
        return false;
    }
}