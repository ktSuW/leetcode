/*
DP + Greedy (make current choice now)
==========================
    0   1   2   3   4   5   6   7   8   9  <= index
    1   100 1   1   1   100 1   1   100 1  <= values
            1
                
                

*/

class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int step1 = 0;
        int step2 = 0;
        int result = 0;
        for(int i = 0; i < cost.length; i++){
            result = cost[i] + Math.min(step1, step2);
            step1 = step2;
            step2 = result;
        }
        return Math.min(step1, step2);
    }
}