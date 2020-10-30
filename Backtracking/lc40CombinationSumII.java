package Backtracking;
import java.util.*;

public class lc40CombinationSumII {
     //[10,1,2,7,6,1,5] target = 8;
    //[[1,2,5],[1,7],[1,6,1][2,6]]
    //Time: O(2^n);
    //Space:O(n)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        // System.out.println(Arrays.toString(candidates));
        backtracking(res, candidates, target, 0, new ArrayList<>());
        return res;
        
    }
    
    private void backtracking(List<List<Integer>> res, int[] candidates, int target, int index, List<Integer> ls) {
       // System.out.println(target + ": " + ls);
        if (target < 0 ){
             return;
        } else if (target == 0) {
            Collections.sort(ls);
            if (!res.contains(ls)) {
                res.add(new ArrayList<>(ls)); 
            }
            return;
        } else {
            for (int i = index; i < candidates.length; i++) {
            if(i > index && candidates[i] == candidates[i-1]) continue; 
            ls.add(candidates[i]);
                //be aware index = i+1, because the given array contains duplicate 
            backtracking(res, candidates, target-candidates[i], i+1, ls);
            ls.remove(ls.size()-1);
            }
        
        }
        
        
        
        
    }
}
