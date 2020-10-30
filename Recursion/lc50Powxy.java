public class lc50Powxy {
//Time O(2^n) 
//Space n
//This method will have runtime error when n is large
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if (n < 0) return negativeHelper(x, n);
        if (n > 0) return positiveHelper(x, n);
        return 1;
    }
    
    public double positiveHelper(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        
        return myPow(x, n-1)*x;
    }
    
    public double negativeHelper(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        
        return myPow(x, n+1)/x;
    }
    
}
