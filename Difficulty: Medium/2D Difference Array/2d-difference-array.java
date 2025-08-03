class Solution {
    public ArrayList<ArrayList<Integer>> applyDiff2D(int[][] mat, int[][] opr) {
        // code here
         ArrayList<ArrayList<Integer>> ansmatrix=new ArrayList<>();
        for(int i=0;i<opr.length;i++){
           int value=opr[i][0];
           int r1=opr[i][1];
           int c1=opr[i][2];
           int r2=opr[i][3];
           int c2=opr[i][4];
           valueSetter(mat,r1,c1,r2,c2,value);
        }
        for(int i=0;i<mat.length;i++){
            ansmatrix.add(new ArrayList<>());
        }
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                ansmatrix.get(i).add(mat[i][j]);
            }
        }
        return ansmatrix;
    }
    public static void valueSetter(int[][] mat,int r1,int c1,int r2,int c2,int value){
        for(int i=r1;i<=r2;i++){
            for(int j=c1;j<=c2;j++){
                mat[i][j]+=value;
            }
        }
    }
}