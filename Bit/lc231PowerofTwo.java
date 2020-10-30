package Bit;

public class lc231PowerofTwo {
    //Time(O(1))
    //Space(O(1))
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        return (n & (n-1)) == 0;
        
    }
}
