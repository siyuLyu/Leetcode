public class lc136SingleNumber {
    //Time O(n)
    //Space O(1)
    //[4,1,2,1,2]
    
    //0:  0 0 0 0
    //4:  0 1 0 0
    //--------------
    //4:  0 1 0 0
   // 1:  0 0 0 1
    // -----------
    //5:  0 1 0 1
    //2:  0 0 1 0
    //------------
    //7:  0 1 1 1
    //1:  0 0 0 1
    //------------
    //6:  0 1 1 0
    //2:  0 0 1 0
    //------------
    //4:  0 1 0 0
      
       
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int n: nums) {
            a^=n;
        }
        return a;
    }
}
