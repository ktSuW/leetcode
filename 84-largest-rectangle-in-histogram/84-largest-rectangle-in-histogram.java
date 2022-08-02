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
*/
// Time complexity O(n)
// Space complexity O(n) due to stack 
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int currentArea = 0;

        for(int i = 0; i <= heights.length; i++){
            while(!stack.isEmpty() && (i == heights.length || heights[i] <= heights[stack.peek()])){
                int height = heights[stack.pop()];
                int width; 
                if(stack.isEmpty()){
                    width = i;
                }else{
                    width = i - stack.peek() -1;
                }
                currentArea = height * width;
                maxArea = Math.max(currentArea, maxArea);
            }
            stack.push(i);
        }
        
        return maxArea;
    }
}