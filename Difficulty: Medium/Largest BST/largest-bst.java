// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {

 

    static class Info {

        int size;

        int min;

        int max;

        boolean isBST;

 

        Info(int size, int min, int max, boolean isBST) {

            this.size = size;

            this.min = min;

            this.max = max;

            this.isBST = isBST;

        }

    }

 

    static int maxSize = 0;

 

    static Info solve(Node root) {

        if (root == null) {

            return new Info(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);

        }

 

        Info left = solve(root.left);

        Info right = solve(root.right);

 

        // Check if current subtree is BST

        if (left.isBST && right.isBST && root.data > left.max && root.data < right.min) {

            int currSize = left.size + right.size + 1;

            maxSize = Math.max(maxSize, currSize);

 

            return new Info(

                currSize,

                Math.min(root.data, left.min),

                Math.max(root.data, right.max),

                true

            );

        }

 

        // Not a BST

        return new Info(0, 0, 0, false);

    }

 

    static int largestBst(Node root) {

        maxSize = 0;

        solve(root);

        return maxSize;

    }

}