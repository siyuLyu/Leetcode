class Solution {
    // Time O(n)
    //Space(O(1))
    public void moveZeroes(int[] nums) {
        //start as slow pointer, i as fast pointer
        //make sure all element befire slow pointer are non zeros
        int start = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[start];
                nums[start] = tmp;
                start++;
            }
        }
        
    }
}