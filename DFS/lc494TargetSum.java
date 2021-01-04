import java.util.*;
class lc494TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        Map<String, Integer> map = new HashMap<>();
        return dfs(map, nums, nums.length -1, S);   
    }
    
    private int dfs(Map<String, Integer> map, int[] nums, int n, int S) {
        if (n == -1 && S == 0) {
            return 1;
        }
        
        if( n <= -1 )   return 0;
        String curr = n + " " +S;
        if (map.containsKey(curr)) {
            return map.get(curr);
        }
        
       
        int ans1 = dfs(map, nums, n-1, S - nums[n]); 
        int ans2 = dfs(map, nums, n-1, S + nums[n]); 
        
        map.put(curr, ans1 + ans2);
        
        return ans1+ ans2;
    }
}