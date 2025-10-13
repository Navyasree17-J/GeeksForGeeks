/*
class Node {
    int data;
    Node left, right;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
     public static int[] rob(Node root){
        if(root ==null){
            return new int[2];
        }
        
        int aRob []= rob(root.left);
        int bRob []= rob(root.right);
        
        int options[] = new int[2];

        options[0] = root.data + aRob[1]+bRob[1];

        options[1] = Math.max(aRob[0],aRob[1]) + Math.max(bRob[0],bRob[1]);
        
        return options;
 
    }
    public int getMaxSum(Node root) {
        // code here
          int twoChoicesToRob [] = rob(root);
        
        return Math.max(twoChoicesToRob[0],twoChoicesToRob[1]);
        
    }
}