/*
Time complexity O(3n);
Space O(2n) for lmax and rmax
This approach is DP. memoising the value 
-----------------
Learn about Monotonic stack
Two pointers approach 
*/
class Solution {
    public int trap(int[] height) {
        int result = 0;
        int leftMax = Integer.MIN_VALUE;
        int[] lmax = new int[height.length];
        int[] rmax = new int[height.length];
        
        for(int i =0; i < height.length; i++){
            leftMax = Math.max(height[i], leftMax);
            lmax[i] = Math.max(leftMax, height[i]);
            // System.out.print(lmax[i] + " ");
        }
        
        int rightMax = Integer.MIN_VALUE;
        for(int i = rmax.length -1; i >= 0; i--){
            rightMax = Math.max(height[i], rightMax);
            rmax[i] = Math.max(rightMax, height[i]);
        }
        
        for(int i =0; i < lmax.length; i++){
            result += Math.min(lmax[i], rmax[i]) - height[i];
        }
        return result;
    }
}