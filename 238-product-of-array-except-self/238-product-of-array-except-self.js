/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {
    const n = nums.length;
    var left = [n];
    var right = [n];
    var result = [n];
    left[0] = 1;
    right[n-1] = 1;
    
    for(let i = 1; i < n; i++){
        left[i] = nums[i-1] * left[i-1];
    }
    
    for(let i = n-2; i >= 0; i--){
        right[i] = right[i+1] * nums[i+1];
    }
    
    for(let i = 0; i < n; i++){
        result[i] = left[i] * right[i];
    }
    return result;
};