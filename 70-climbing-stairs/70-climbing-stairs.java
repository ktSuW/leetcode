/*
1D problem in DP
=========================
- Identify whether it is a DP problem
    - count total number of ways
    - count distinct number
    - multiple ways of doing something
    - give min/ max output 
    - try all possible ways 
    - count how many ways are there / figure out the best ways 
- Apply recursion 
- Technique
    1) Try to represent the problem in terms of index for array 
    2) Do all possible stuff on that index according to the problem statement
    3) sum up all stuff --> count all ways
        if the question asks min(of all the things)
    
    0------------------> n
    1) Assume each stair to be an index 
    2) Recursion 
        f(n) => number of ways (0 -> n)
        f(index == 0) return 1;
        f(index == 1) return 1;
   

*/

class Solution {
    public int climbStairs(int n) {
        // This is a recurrence relationship.
        // recursive step is too deep. so TLE.
        // if(n <= 2) return n;
        // return climbStairs(n-1) + climbStairs(n-2);
        //========================================
        // Memoisation 

        // int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // if(n <= 2) return n;
        // return dp[n] = climbStairs(n -1) + climbStairs(n -2) ;
        //========================================
        if(n <= 2) return n;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
        //=========================================
        // if(n <= 2) return n;
        // int step1 = 1;
        // int step2 = 2;
        // int result = 0;
        // for(int i = 3; i <= n; i++){
        //     // fibonacci sequence
        //     // 
        //     result = step1 + step2;
        //     step1 = step2;
        //     step2 = result;
        // }
        // return result;
    }
}