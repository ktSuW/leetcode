/*
Use two pointers technique
    a       b       -       c       d
start                               end
    ^                               ^
    
    d       b       -       c       a <=
            ^               ^
            

Three cases
1. both s[start] and s[end] are letters. so swap
    Use in-place swapping algortihm
    char temp = s[stat];
    s[start] = s[end];
    s[end]  = temp;
2. if s[start] is not letter, move start pointer
3. if s[end] is not letter, move end pointer

After finishing, return a new reversed string 

Time complexity for two pointers - O(n)
Space - O(n)

Two Pointers approach
==================================
class Solution {
    public String reverseOnlyLetters(String s) {
        int start = 0;
        int end = s.length()-1;
        //convert s to char array
        char[] arr = s.toCharArray();
        
        while(start < end) {
            if(Character.isLetter(arr[start]) && Character.isLetter(arr[end])){
                // swap using inplace swapping 
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }else if(!Character.isLetter(arr[start])){
                start++;
            }else if(!Character.isLetter(arr[end])){
                end--;
            }
        }
        return new String(arr);
    }
}
*/

class Solution {
    public String reverseOnlyLetters(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for(int i =0; i < s.length(); i++){
            if(Character.isLetter(s.charAt(i))){
                stack.push(s.charAt(i));
            }
        }
        for(char c : s.toCharArray()){
            if(Character.isLetter(c)){
                result.append(stack.pop());
            }else{
                result.append(c);
            }
        }
        return result.toString();
    }
}
