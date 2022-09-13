/*
Mixed of DP and greedy
    0   1   2   3   4   5   6   7   8   9  <= index
    1   100 1   1   1   100 1   1   100 1  <= values
    s1  s2
    cs = 1 + min(100,1) -> 1 = 2
    
        s1  s2

*/

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int step1 = 0;
        int step2 = 0;
        for(int i = 0; i < cost.length ; i++){
            int currentStep = cost[i] + Math.min(step1, step2);
            step1 = step2;
            step2 = currentStep;
        }
        return Math.min(step1, step2);
    }
}