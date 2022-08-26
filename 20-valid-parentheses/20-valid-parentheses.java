/*
0. Initialise the stack
1. If the character at i index is equal to 
    (
    [
    {
  push the corresponding closing brackings into the stack.

2. Else 
    2.1 if the stack is empty, that means we are at the end of the string array 
    2.2 the popped character must be same as the char at the current index , if they are not
        then the string is not a valid parenthesis
3. At the end of the string, if the stack is empty, it is a balanced parenthesis

Time complexity 
O(n)
Space Complexity 
O(n)

*/


class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(')');
            } else if(c == '['){
                stack.push(']');
            } else if(c == '{'){
                stack.push('}');
            }else if (stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();
    }
}