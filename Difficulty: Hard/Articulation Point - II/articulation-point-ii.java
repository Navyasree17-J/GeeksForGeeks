//{ Driver Code Starts
import java.util.*;

public class Main {
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
            ArrayList<Integer> ans = obj.articulationPoints(V, edges);
            Collections.sort(ans);
            for (int val : ans) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
          ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Step 2: Initialize the necessary arrays
        int[] disc = new int[V];  // discovery times of visited vertices
        int[] low = new int[V];   // earliest visited vertex reachable
        int[] parent = new int[V]; // parent vertices in DFS tree
        boolean[] ap = new boolean[V]; // articulation points array

        Arrays.fill(disc, -1); // Initialize all discovery times to -1
        Arrays.fill(parent, -1); // Initialize parent of all vertices to -1
        
        // Step 3: Initialize DFS variables
        int time = 0; // global time for DFS
        // Step 4: Run DFS from all unvisited vertices (in case of disconnected graph)
        for (int i = 0; i < V; i++) {
            if (disc[i] == -1) {
                dfs(i, disc, low, parent, ap, graph, time);
            }
        }

        // Step 5: Collect the articulation points
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (ap[i]) {
                result.add(i);
            }
        }

        // If no articulation points were found, return {-1}
        if (result.isEmpty()) {
            result.add(-1);
        }
        
        return result;
    }

    // Helper method to perform DFS and find articulation points
    private static void dfs(int u, int[] disc, int[] low, int[] parent, boolean[] ap, ArrayList<ArrayList<Integer>> graph, int time) {
        // Initialize discovery time and low value
        disc[u] = low[u] = ++time;
        int children = 0;

        // Visit all neighbors of vertex u
        for (int v : graph.get(u)) {
            if (disc[v] == -1) {  // If v is not visited yet
                parent[v] = u;
                children++;
                dfs(v, disc, low, parent, ap, graph, time);

                // Check if the subtree rooted at v has a connection back to one of the ancestors of u
                low[u] = Math.min(low[u], low[v]);

                // u is an articulation point if it's the root and has more than one child
                if (parent[u] == -1 && children > 1) {
                    ap[u] = true;
                }

                // u is an articulation point if it's not the root and low value of one of its child is more
                if (parent[u] != -1 && low[v] >= disc[u]) {
                    ap[u] = true;
                }
            }
            // Update low[u] for back edge
            else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}