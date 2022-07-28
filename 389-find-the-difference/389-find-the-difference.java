/*
- Sort array
- Hashmap Approch
=================================

Time - O(n)
Space - O(s.length())

class Solution {
    public char findTheDifference(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char k = s.charAt(i);
            if(map.containsKey(k)){
                //increment the value
                map.put(k, map.get(k)+1);
            }else{
                map.put(k, 1);
            }
        }

        
        for(int i = 0; i < t.length(); i++){
            char k = t.charAt(i);
            if(!map.containsKey(k)){
                return k;
                
            }
            else if(map.get(k) == 0){
                return k;
            }
            else {
                map.put(k, map.get(k)-1);
            }
        }
        

        return 'n';
    }
}



====================================================
- Bit manipulation
    - Computer understands only 0 and 1
    - The data we write in words and number are encoded to a series of 0 and 1
    - 0 and 1 are bits 
- Bit => Binary digit => 0 and 1 
        0       0       1       0
        2^3     2^2     2^1     2^0
    
- BIt wise operations
        x       y       x & y       x | y       x^y     ~(x)
        0       0       0              0        0       1
        0       1       0               1       1       1
        1       0       0               1       1       0
        1       1       1               1       0       0
    
- xOR Exclusive OR 
    - Bits in the compared position does not match its resulting bit => 1
                if they match => 0 
                
    - string a      a
    - string t      ae
                    ------
                    0
STEPS
===========
1. initialise result as t.length() -1 since t is 1 larger in size 
2.Now xOR that result with both 

Time O(n)
Space O(1)
*/

class Solution {
    public char findTheDifference(String s, String t) {
        // char result = 0;
//         for(int i = 0; i < s.length(); i++){
//             result ^= s.charAt(i);
//             // System.out.println(result);
//         }
        
//         for(int i = 0; i < t.length(); i++){
//             result ^= t.charAt(i);
//         }
        char result = t.charAt(t.length()-1);
        for(int i = 0; i < s.length(); i++){
            result ^= s.charAt(i) ^ t.charAt(i);
        }
        
        
        return result;
    }
}



















