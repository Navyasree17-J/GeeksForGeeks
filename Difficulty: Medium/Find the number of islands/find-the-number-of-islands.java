//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        while (tc-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.countIslands(grid);
            System.out.println(ans);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    int[] dx={-1,1,0,0,-1,-1,1,1};
    int[] dy={0,0,-1,1,-1,1,-1,1};
    public int countIslands(char[][] grid) {
        if(grid==null || grid.length == 0) return 0;
        int numRows = grid.length;
        int numCols = grid[0].length;
        int islandCount = 0;
        for(int i = 0; i<numRows; i++){
            for(int j = 0; j<numCols; j++){
                if(grid[i][j] == 'L'){
                    islandCount++;
                    dfs(grid, i, j, numRows, numCols);
                }
            }
        }
        return islandCount;
    }
    private void dfs(char[][] grid, int i, int j, int numRows, int numCols){
        grid[i][j] = 'W';
        for(int dir = 0; dir < 8; dir++){
            int newX = i + dx[dir];
            int newY = j + dy[dir];
            if(newX >= 0 && newX < numRows && newY >= 0 && newY < numCols && grid[newX][newY] == 'L'){
                dfs(grid, newX, newY, numRows, numCols);
            }
        }
    }
}