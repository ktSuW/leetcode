/*
Brute Force, but it will not work if any of the element is 0.
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        for(int i = 0; i < nums.length; i++){
            product *= nums[i];
        }
        
        int result[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0 && product != 0){
                result[i] = product/nums[i];
            }
        }
        return result;
    }
                    1   2   3   4
left Array        1   2
right Array
Output 

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n];
        
        left[0] =1;
        right[n-1] = 1;
        
        for(int i = 1; i < nums.length; i++){
            left[i] = left[i-1] * nums[i-1];
        }
        for(int i = n-2; i >= 0; i--){
            right[i] = right[i+1] * nums[i+1];
        }
        for(int i = 0; i < n; i++){
            result[i] = left[i] * right[i];
        }
        return result;
    }
*/

class Solution {
    // Time O(n)
    // Space O(1)
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        for(int i = 1; i < n; i++){
            result[i] =result[i-1] * nums[i-1];
        }
        
        int rightProduct = 1;
        for(int i = n -1; i >= 0; i--){
            result[i] = rightProduct * result[i];
            rightProduct = rightProduct * nums[i];
        }
        return result;
    }
}