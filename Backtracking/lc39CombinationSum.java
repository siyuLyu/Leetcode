import java.util.*;
class Solution {
    //[2,3,6,7] target = 7
    //Time O(2^n)
    //Spece O(n)
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        
        backtracking(res, candidates, new ArrayList<>(), target, 0);
        
        return res;
        
    }
    
    private void backtracking(List<List<Integer>> res, int[] candidates, List<Integer> ls, int target, int index) {
        if (target == 0) {
        //Writing new ArrayList<>(list) creates a new list, containing all the elements in list.since at the end of the function you are calling list.remove(list.size()-1);, you are thus modifying the list variable.

//If you were to add list directly in res, the remove call would also modify res.
           res.add(new ArrayList<>(ls));
            return;
        }
        //don't forget return when target < 0
        if (target < 0){
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            ls.add(candidates[i]);
            //index = i, because can use unlimited times i
            backtracking(res, candidates, ls, target-candidates[i], i);
            ls.remove(ls.size()-1);
        }
    }
}