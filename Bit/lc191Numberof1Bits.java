package Array.Bit;

public class lc191Numberof1Bits {
    // you need to treat n as an unsigned value
    //Time: O(1)
    //Space O(1)
    
    
    // n & (n-1)
//      <----- binary ---->
//  n      n    n-1   n&(n-1)
// --   ----   ----   -------
//  0   0000   0111    0000 *
//  1   0001   0000    0000 *
//  2   0010   0001    0000 *
//  3   0011   0010    0010
//  4   0100   0011    0000 *
//  5   0101   0100    0100
//  6   0110   0101    0100
//  7   0111   0110    0110
//  8   1000   0111    0000 *
//  9   1001   1000    1000
// 10   1010   1001    1000
// 11   1011   1010    1010
// 12   1100   1011    1000
// 13   1101   1100    1100
// 14   1110   1101    1100
// 15   1111   1110    1110
// You can see that only 0 and the powers of two (1, 2, 4 and 8) result in a 0000/false bit pattern, all others are non-zero or true.
    // n:  110100
    //n-1: 110011
    //   & ----------
     //    110000

//n&(n-1) flip the least significant 1bit into 0
public int hammingWeight(int n) {
    int count = 0;
    while (n != 0) {
        n &= (n-1);
        System.out.println(n);
        count++;
    }
    return count;
}
    
}
