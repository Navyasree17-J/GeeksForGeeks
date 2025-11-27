/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public int findMedian(Node root) {
        // Code here
        ArrayList<Integer>al=new ArrayList<>();
        bst(root,al);
        if(al.size()%2==0)
        {
           int n=al.size()/2;
           return al.get(n-1);
        }
        else
        {
          int n=(al.size()+1)/2;
          return al.get(n-1);
        }
    }
public void bst(Node root,ArrayList<Integer>al)
{
   if(root==null) return;
   bst(root.left,al);
   al.add(root.data);
   bst(root.right,al);
   
    }
}