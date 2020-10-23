import java.util.*;

class Solution {
    //Method 1
    boolean res = false;
    public boolean canReach(int[] arr, int start) {
        //Time O(n)
        //Space O(n)
        
       Set<Integer> set = new HashSet<>();
       dfs(arr, start, set);
        
        return res;
        
    }
    
    private void dfs(int[] arr, int index,Set<Integer> set) {
        if (arr.length == set.size() || index <0 || index > arr.length-1) return;
        
        set.add(index);
        
        if(arr[index] == 0){
            res = true;
            return;
        }
        
        if (!set.contains(index + arr[index])) {
            dfs(arr, index + arr[index], set);
        }
        
         
        if (!set.contains(index - arr[index])) {
            dfs(arr, index - arr[index], set);
        }
    }

    //Method 2
    public boolean canReach2(int[] arr, int start) {
        if (start >= 0 && start < arr.length && arr[start] >= 0) {
            if (arr[start] == 0) {
                return true;
            }
            arr[start] = -arr[start];
            return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
        }
        return false;
    }
}