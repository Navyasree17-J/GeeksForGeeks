//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(mat);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int orangesRotting(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[] dirX = {-1,1,0,0};
        int[] dirY = {0,0,-1,1};
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        for(int i=0;i<rows;i++){
            for(int j=0; j<cols;j++){
                if(mat[i][j]==2){
                    queue.add(new int[]{i,j});
                }else if (mat[i][j]==1){
                    freshCount++;
                }
            }
        }
        if(freshCount==0){
            return 0;
        }
        int time =0;
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean rotThisTurn=false;
            for(int i=0; i<size; i++){
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                for(int j=0; j<4; j++){
                    int newX = x+dirX[j];
                    int newY = y+dirY[j];
                    if(newX >= 0 && newX<rows && newY >= 0 && newY < cols && mat[newX][newY]==1){
                        mat[newX][newY]=2;
                        freshCount--;
                        queue.add(new int[]{newX, newY});
                        rotThisTurn=true;
                    }
                }
            }
            if(rotThisTurn){
                time++;
            }
        }
        return freshCount==0 ? time: -1;
    }
}