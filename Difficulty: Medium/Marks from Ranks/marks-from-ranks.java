class Solution {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        // code here
        ArrayList<Integer> list=new ArrayList<>();

        int i=0;
        int j=0;


        while(i<l.length && j<r.length){

            for(int k=l[i];k<=r[j];k++){
                list.add(k);
            }
            i++;
            j++;


        }

        while(i<l.length){

            list.add(l[i]);
            i++;
        }

        while(j<r.length){
            list.add(r[j]);

            j++;
        }


        ArrayList<Integer> ans=new ArrayList<>();

        for(int m=0;m<rank.length;m++){


            int no=rank[m];

            ans.add(list.get(no-1));
        }

        return ans;
    }
}