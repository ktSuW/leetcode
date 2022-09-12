class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        int step1 = 1;
        int step2 = 2;
        int result = 0;
        for(int i = 3; i <= n; i++){
            result = step1 + step2;
            step1 = step2;
            step2 = result;
        }
        return result;
    }
}