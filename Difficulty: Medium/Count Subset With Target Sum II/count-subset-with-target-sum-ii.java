class Solution {
    List<List<Integer>> store(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            if(i < n / 2) ans.get(0).add(arr[i]);
            else ans.get(1).add(arr[i]);
        }
        return ans;
    }
    List<Integer> generate(List<Integer> arr) {
        List<Integer> ans = new ArrayList<>();
        int n = arr.size();
        
        for(int m = 0; m < (1 << n); m++) {
            int sum = 0;
            
            for(int b = 0; b < n; b++) {
                if(((m >> b) & 1) != 0) {
                    sum += arr.get(b);
                }
            }
            ans.add(sum);
        }
        return ans;
    }
    int firstIndex(List<Integer> arr, int x) {
        int s = 0;
        int e = arr.size() - 1;
        int ans = -1;
        while(s <= e) {
            int mid = s + (e - s) / 2;
            if(arr.get(mid) == x) {
                ans = mid;
                e = mid - 1;
            }
            else if(arr.get(mid) > x) {
                e = mid - 1;
            }
            else {
                s = mid + 1;
            }
        }
        return ans;
    }
    int lastIndex(List<Integer> arr, int x) {
        int s = 0;
        int e = arr.size() - 1;
        int ans = -1;
        while(s <= e) {
            int mid = s + (e - s) / 2;
            if(arr.get(mid) == x) {
                ans = mid;
                s = mid + 1;
            }
            else if(arr.get(mid) > x) {
                e = mid - 1;
            }
            else {
                s = mid + 1;
            }
        }
        return ans;
    }
    public int countSubset(int[] arr, int k) {
        // code here
        List<List<Integer>> values = store(arr);
        List<Integer> left = generate(values.get(0));
        List<Integer> right = generate(values.get(1));
        int ans = 0;
        
        Collections.sort(right);
        
        for(int next : left) {
            int target = k - next;
            int f = firstIndex(right, target);
            if(f != -1) {
                int s = lastIndex(right, target);
                ans += s - f + 1;
            }
        }
        return ans;
    }
}