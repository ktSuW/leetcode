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

**/

class Solution {
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
}