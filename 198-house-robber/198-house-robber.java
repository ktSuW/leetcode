/**
2   1   4   9

Try all options with given constraint 

2       4       = 6
2           9   = 13
    1       9   = 10
        4       = 4

Try all options => Recursion
Find out overlapping subproblems
- pick the value
- do not pick the value 
1. express as index
2. Do operatios on index
3. return the best 
                
selected = nums[index] + func(index-1) -> you cannot pick index-1 because it is adjacent;
notSelected = nums[index] + func(index-2) -> you cannot pick index-2 because it is NOT adjacent;
not pick = 0 + func()

return Math.max(selected, notSelected);
edge case: index < 0 => return 0;
    // Option 1 : recursive approach - TLE
    // O(2n)
    public int rob(int[] nums) {
        //recursion
        return rob(nums,0);
    }
    
    private int rob(int[] nums, int index){
        //edge case
        if(index >= nums.length) return 0;
        int selected = rob(nums, index+2) + nums[index];
        int notSelected = rob(nums, index+1);
        return Math.max(selected, notSelected);
    }
====================================================
Option 2: 
Find out recursion has overlapping subproblems
If yes, we can memoise it to optimise the space complexity 

n states 
dp[n] =1;
TC O(n)
SC O(n) for stack space + O(n) array space 
    //Option -2 : Optimised recursion with memoising the already calculated rob result
    int [] dp ;
    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return rob(nums, nums.length -1);
    }
    
    private int rob(int[] nums, int index){

        if(index < 0) return 0;
        if(dp[index] != -1) 
            return dp[index];
        int selected = rob(nums, index-2) + nums[index];
        int notSelected = rob(nums, index-1);
        return dp[index] = Math.max(selected, notSelected);
    }
===============================================================
//Option -3 : Convert memoisation to tabulation
    // Tabulation is a bottom up approach. therefore build up from 0 till n
    // Time Complexity - O(n)
    // Space Complexity - O(n)
    // No recursive call stack space 
    //base case
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
 
        for(int i = 2; i < nums.length; i++){
            int selected = nums[i] + dp[i-2];
            int notSelected = 0 + dp[i-1];
            dp[i] = Math.max(selected, notSelected);
        }
        return dp[nums.length-1];
================================================================

**/

class Solution {
    public int rob(int[] nums) {
    //Option -4 : Opimise Tabulation to space optimise to achieve O(1) space complexity 
    // prev2    prev1   curr
    //          prev2   prev1  curr
    // prev2 = prev1;
    // prev1 = curr;
       if(nums.length == 0) return 0;
        int prev1 = nums[0];
        int prev2 = 0;

        for(int i = 1; i < nums.length; i++){
            int selected = nums[i] + prev2;
            int notSelected = 0 + prev1;
            int curr = Math.max(selected, notSelected);
            prev2 = prev1;
            prev1 = curr;
            
        }
        return prev1;
    }
}