public class lc509FibonacciNumber {
    //Time 2^n
    // space O(N) possible stack overflow when N is large
    public int fib(int N) {
        //base case
        if(N == 0) return 0;
        if(N <= 2) return 1;
        //recursive call
        return fib(N-1) + fib(N-2);
        
    }
    // method 2 is not recursive it use memoization 
    public int fib2(int N) {
        //Time O(n)
        //Space O(n)
        if(N == 0) return 0;
        if(N == 1) return 1;
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= N; i++) {
            dp[i] = dp[i-1]+ dp[i-2];
        }
        
        return dp[N];
    }
    
}
