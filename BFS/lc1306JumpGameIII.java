import java.util.*;
class Solution {
    public boolean canReach(int[] arr, int start) {
        // Time O(n)            
        // Space O(n)
        //   
        //
        int n = arr.length-1;
        Queue<int[]> q = new LinkedList<>();
        int[] tmp = new int[2];
        tmp[0] = start;
        tmp[1] = arr[start];
        q.add(tmp);
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            if(curr[0]+curr[1] <= n) {
                int[] r = new int[2];
                r[0] = curr[0] + curr[1];
                r[1] = arr[r[0]];
                if(helper(arr, curr[0], r[0])) return true;
                if(! visited.contains(r[0])) {
                    q.add(r);
                    visited.add(r[0]);
                }
                
                
            }
            
            if(curr[0]-curr[1] >= 0) {
                int[] l = new int[2];
                l[0] = curr[0] - curr[1];
                l[1] = arr[l[0]];
                if(helper(arr, l[0], curr[0])) return true;
                if(!visited.contains(l[0])) {
                    q.add(l);
                    visited.add(l[0]);
                }
            }
            
        }
        return false;
        
    }
    // can be improved by return boolean value in the while loop
    private boolean helper(int[] arr, int start, int end) {
        if (arr[start] == 0) return true;
        if (arr[end] == 0) return true;
        
        return false;
    }
}