/*
// First and last are adjacent 

    0       1       2 <= index
    2       3       2 <= elements 
    
    First and lastones are adjacent. Therefore, I cannot select both.
    I can either pick either first or last
    Leave out the last possible element
    choice1 => choose from 0 till n-2 
    choice2 => chose from 1 till the last element 
    
    Math.max(choice1, choice2);
    

*/

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] temp1 = new int[n];
        int[] temp2 = new int[n];
        
        for(int i = 0; i < n; i++){
            if(i != 0){
                temp1[i] = nums[i];
            }
            if(i != n-1){
                temp2[i] = nums[i];
            }
        }
        return Math.max(findMaxSum(temp1), findMaxSum(temp2));
    }
    
    private int findMaxSum(int[] nums){
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









