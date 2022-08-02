/*
Monotonic increasing stack
A monotonic stack is a stack whose elements are monotonically increasing or descreasing.
// https://liuzhenglaichn.gitbook.io/algorithm/monotonic-stack
// https://developpaper.com/what-is-a-monotonous-stack/
// https://stackoverflow.com/questions/55780200/intuition-behind-using-a-monotonic-stack
Store the index of the stack
Height of the array itself can be found easily

1. Create a stack
2. Compare the condition ith element 
    if stack if empty
        height[i] >= height[stack.peek()]
            then push i index into the stack
    if height[i] < height[stack.peek()]
        pop the elemnt from the stack
        calculate the result if needed.
        area = height[top] * i;
                            
        area = height[top] * (i - top - 1) to get the width 
        
 There could still be some indexes left. So to handle this case, 
    Check for stack is not empty
        - Keep popping up and calcuate the area like above
        
=========================================================
- Brute Force
------------------
- Go all the way until the value is less than myself - both sides 
    - This is to get the width

Iterate through once , keep log of what you have visted 
- Once you find a bar smaller than yourself, stop.
    - find left side, if smaller. Calculate current var area. And then take the index out 
*/
// Time complexity O(n)
// Space complexity O(n) due to stack 
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int currentArea = 0;
        int i = 0;
        while(i < heights.length){
            if(stack.isEmpty() || heights[i] >= heights[stack.peek()]){
                stack.push(i);
                i++;
            }else{
                // start computing the area
                int height = heights[stack.pop()];
                int width;
                // width = stack.isEmpty() ? (i-1) : i - 1 - stack.peek();
                // You don't want to go beyound the boundary
                if(stack.isEmpty()){
                    width = i ;
    
                }else{
                    width = i - 1 - stack.peek();
    
                }
                currentArea = height * width;
                maxArea = Math.max(currentArea, maxArea);
            } 
           
            
        }
        //Some bars might be left - which areas are yet to be calculated for
        while(!stack.isEmpty()){
                int height = heights[stack.pop()];
                int width = (stack.isEmpty()) ? i : i - 1- stack.peek();
//                 if(stack.isEmpty()){
//                     width = i;

//                 }else{
//                     width = i - 1 - stack.peek();
      
//                 }
                // since it is 
                currentArea = height * width;
                maxArea = Math.max(currentArea, maxArea);
        }
        
        return maxArea;
    }
}