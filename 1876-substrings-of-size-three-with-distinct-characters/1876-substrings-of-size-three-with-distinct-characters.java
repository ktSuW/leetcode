// Time O(n)
// Space O(n)
/*
Option 1 
    public int countGoodSubstrings(String s) {
 
        int result = 0;
        // Add -2 to the length() to ensure end can move till the end of the array
        // Use two pointers approach to cover for length of three
        // start pointer 
        // end pointer => they both need to start from the same point 
        for(int start =0; start<s.length()-2; start++){
            // if(i+3 > s.length()) break;
            // Since set is initialised inside start, every time, new set will be initialised, and empty set.
            // Therefore, we don't need to worry about clearing the set for each end iteration
            // However, it could imapct on the memory 
            Set<Character> set = new HashSet<>();
            for(int end= start; end < start+3;end++){
                set.add(s.charAt(end));
            }
            if(set.size()==3){
                result++;
            }
        }
        return result;
    }
    
==========================================
*/
// Time O(n)
// Space O(n)
/*
    public int countGoodSubstrings(String s) {
 
        int result = 0;
        
        for(int i = 0; i < s.length() - 2; i++){
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            set.add(s.charAt(i+1));
            set.add(s.charAt(i+2));
            if(set.size() ==3) result++;
            else{
                set.remove(0);
            }
        }
        return result;
    }
*/
class Solution {
    public int countGoodSubstrings(String s) {
 
        int result = 0;
        
        for(int i = 0; i < s.length() - 2; i++){
            if(s.charAt(i) != s.charAt(i+1) &&
                s.charAt(i+1) != s.charAt(i+2) &&
               s.charAt(i) != s.charAt(i+2)
              ){
                result++;
            }
        }
        return result;
    }
}