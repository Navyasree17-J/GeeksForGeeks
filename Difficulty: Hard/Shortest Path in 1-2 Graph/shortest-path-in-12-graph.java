class Solution {
    public int shortestPath(int V, int src, int dest, int[][] edges) {
        // code here
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {

            adj.add(new ArrayList<>());

        }

        

        for (int[] edge : edges) {

            int u = edge[0];

            int v = edge[1];

            int w = edge[2];

            adj.get(u).add(new int[]{v, w});

            adj.get(v).add(new int[]{u, w});

        }

        

        // 2. Initialize tracking arrays

        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        

        // 3. Standard FIFO Queue

        Queue<Integer> queue = new LinkedList<>();

        queue.add(src);

        

        while (!queue.isEmpty()) {

            int u = queue.poll();

            

            for (int[] neighbor : adj.get(u)) {

                int v = neighbor[0];

                int weight = neighbor[1];

                

                // If a shorter path to neighbor is found

                if (dist[u] + weight < dist[v]) {

                    dist[v] = dist[u] + weight;

                    queue.add(v);

                }

            }

        }

        

        return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
    }
}