/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    public ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> arr=new ArrayList<Integer>();
        // code here
        if(root==null)
        {
            return arr;
        }
        TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>();
        Queue<Node> q=new LinkedList<Node>();//nodes accesssing
        
        Queue<Integer> hd=new LinkedList<>();//horizontal distance
        
        q.add(root);
        hd.add(0);
        while(!q.isEmpty())
        {
            Node curr=q.poll();
            int h=hd.poll();
            if(!map.containsKey(h))
            {
                map.put(h,curr.data);
            }
            if(curr.left != null) {
                q.add(curr.left);
                hd.add(h - 1);
            }
            if(curr.right != null) {
                q.add(curr.right);
                hd.add(h + 1);
            }
        }
        for(int i:map.values())
        {
            arr.add(i);
        }
        return arr;
    }
}