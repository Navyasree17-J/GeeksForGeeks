//{ Driver Code Starts
// Initial Template for Java
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
            boolean ans = obj.isCycle(V, edges);
            System.out.println(ans ? "true" : "false");
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public boolean isCycle(int V, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[V];
        for(int i =0; i<V; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge:edges){
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        boolean[] visited= new boolean[V];
        for(int i=0; i<V; i++){
            if(!visited[i]){
                if(dfs(graph, i, -1, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(ArrayList<Integer>[] graph, int v, int parent,boolean[] visited){
        visited[v] = true;
        for(int neighbor : graph[v]){
            if(!visited[neighbor]){
                if(dfs(graph, neighbor,v, visited)){
                    return true;
                }
            }else if (neighbor != parent){
                return true;
            }
        }
        return false;
    }
} 
