class Solution {
    public int minSteps(int[] arr, int start, int end) {
        // code here
        if(start == end){
            return 0;
        }
        //start even end odd
        if((start % 2 ==0) && (end % 2 !=0)){
            return -1;
        }
        int []distance=new int[1000];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[start]=0;
        Queue <Integer>q=new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int num : arr){
                int next=(curr * num ) % 1000;
                if(next == end ) return (distance[curr]+1);
                else{
                    if(distance[next]==Integer.MAX_VALUE){
                        distance[next]=distance[curr] + 1;
                        q.offer(next);
                    }
                }
            }
        }
        return -1;
    }
}