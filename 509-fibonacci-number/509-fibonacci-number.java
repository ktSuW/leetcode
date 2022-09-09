/*
    public int fib(int n) {
        // recursion approach 
        // Space (n) recursive call stack 
        if(n <= 1) return n;
        return fib(n-1) + fib(n-2);
    }
    //==============================================
    
        public int fib(int n) {
    // DP approach - memoisation
    // Time complexity O(n)
        // Space O(n) recursive call stack + O(n) for dp array 
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        if(n <= 1) return n;
        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = fib(n-1) + fib(n-2);
    }
    //==================================================
    
*/
class Solution {
    public int fib(int n) {
    // Tabulation - bottom up
    // try to go from base case and bottom to up
        // Space O(n) - remove recursive stack space 
        // Time O(n)
        // check recurrence relation
        // fib (n-1) + fib(n-2)
        if(n <= 1) return n;
        int[] save = new int[n+1];
        save[0] = 0;
        save[1] = 1;
        for(int i = 2; i <=n; i++){
            save[i] = save[i-1]+ save[i-2];
        }
        return save[n];
    }
}













