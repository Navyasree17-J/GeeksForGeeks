//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] edge = new int[n][2];
            for (int i = 0; i < n; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res = obj.minCost(edge);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends




class Solution {

    public int minCost(int[][] houses) {
        int n = houses.length;
        boolean[] visited = new boolean[n]; // track visited houses
        int[] minDist = new int[n];         // min distance to the MST

        // Initialize all distances as infinity
        for (int i = 0; i < n; i++) {
            minDist[i] = 1000000; // large number as infinity
        }

        minDist[0] = 0; // start from the first house
        int totalCost = 0;

        for (int count = 0; count < n; count++) {
            int u = -1;
            int min = 1000000;

            // Find the unvisited node with the smallest distance
            for (int i = 0; i < n; i++) {
                if (!visited[i] && minDist[i] < min) {
                    min = minDist[i];
                    u = i;
                }
            }

            // Add that house to the MST
            visited[u] = true;
            totalCost += minDist[u];

            // Update distances of adjacent unvisited houses
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    int cost = Math.abs(houses[u][0] - houses[v][0]) + Math.abs(houses[u][1] - houses[v][1]);
                    if (cost < minDist[v]) {
                        minDist[v] = cost;
                    }
                }
            }
        }

        return totalCost;
    }
}
