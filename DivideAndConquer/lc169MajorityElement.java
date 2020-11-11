class Solution {
    //Time: O(nlogn)
    //Space O(n) call stack
    public int majorityElement(int[] nums) {
        return helper(nums, 0, nums.length-1);
        
    }
    
    private int helper(int[] nums, int l, int r) {
        //base case,the only element in an array of size 1 is the majority
        if (l >= r) {
            return nums[l];
        }
        
        int mid = l + (r-l)/2;
        
        int left = helper(nums, l, mid);
        int right = helper(nums, mid+1, r);
        
        //if left majority and right majority are the same , return
        if(left == right) return left;
        
        int leftCount = count(nums, l, mid, left);
        int rightCount = count(nums, mid+1, r, right);
        
        return leftCount > rightCount? left: right;
    }
    
    private int count(int[] nums, int l, int r, int target) {
        int cnt = 0;
        for (int n: nums) {
            if(n == target) {
                cnt++;
            }
        }
        
        return cnt;
    }
}