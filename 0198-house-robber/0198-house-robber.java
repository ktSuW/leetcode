/*
Recursion try all non adjacent sum....
Find overlapping subproblems to optimise the recursion

You need to either pick or not pick of the current index value + index -1 or index -2
    pick = nums[index] + nums[index -2]
    notPick = 0 + nums[index -1];
                
0   1   2   3  <= index
1   2   3   1  <= values
                f(3)
           /        \
         pick        notPick
        f(1)            f(2)
      /   \             /   \
    pick  notPick     pick  notPick
   f(-1)   f(0)       f(1)      f(0)
  
  So, you need a base case 
  Option 1 - Recursive Solution
      // With this recursive solution, you will get TLE
    // Therefore, when you see the overlapping subproblems, instead of calling the function again,
    // you can memoise it in dp array 
    public int rob(int[] nums) {
        int n = nums.length;
        return recurMemo(n-1, nums);
    }
    
    public int recurMemo(int index, int[] nums){
        if(index == 0) return nums[index];
        if(index < 0) return 0;
        
        int pick = nums[index] + recurMemo(index -2, nums);
        int notPick = 0 + recurMemo(index -1, nums);
        return Math.max(pick, notPick);
    }
    
    //==============================================================
        // Method - 2 Memoisation 
    //==============================================================
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return recurMemo(n-1, nums, dp);
    }
    
    public int recurMemo(int index, int[] nums, int[] dp){
        if(index == 0) return nums[index];
        if(index < 0) return 0;
        if(dp[index] != -1){
            return dp[index];
        }
        int pick = nums[index] + recurMemo(index -2, nums, dp);
        int notPick = 0 + recurMemo(index -1, nums, dp);
        return dp[index] = Math.max(pick, notPick);
    }
    
    //=======================================================
    //                  Tabulation
    //=======================================================
        // Method - 3 Tabulation
    // TC O(n)
    // Space Com - O(n) without auxillary stack space 
    //====================================
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 0);
        if(n == 1) return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i = 2; i < n; i++){
            int pick = nums[i] + dp[i-2];
            int notPick = 0 + dp[i-1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[n-1];
    }
    //==============================================================
    //      Method 4 : Tabulation with space optimisation SC O(1)
    //==============================================================
*/
class Solution {
    // Method - 3 Tabulation
    // TC O(n)
    // Space Com - O(n) without auxillary stack space 
    //====================================
    
    // -    -       -       -      -        -   
    //      i-2     i-1     i
    //      prev2   prev1   curr
    //              prev2   prev1  curr
    // You just need two variables 
    
    public int rob(int[] nums) {
        int n = nums.length;

        int prev1 = nums[0];
        int prev2 = 0;

        for(int i = 1; i < n; i++){

            int pick = nums[i] + prev2;
            int notPick = 0 + prev1;
            int curr = Math.max(pick, notPick);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}





