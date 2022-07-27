class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int p1 = 0, p2 = 0;
        int p1Len = s.length();
        int p2Len = t.length();
 
        while(p2Len > 0 && p1Len > 0){
            // characters are same
            if(s.charAt(p1) == t.charAt(p2)){
                p1++;
                p2++;
                p1Len--;
                p2Len--;
                if(p1Len == 0) return true;
            }else{
                p2++;
                p2Len--;
            }
        }
        // if(p1Len > 0) {
        //     return false;
        // }else {
        //     return true;
        // }
        
        return p1Len > 0 ? false : true;
    }
}

/*
   while() stopping condidtion
       1. 
        a   e   c => s string 
        ^
                p1  
        s.length() = 3;
        everytime I move p1, I should reduce the count 
        z   a   b   c   d   e => t string
        ^               
                                p2  
        
        2. 
        
        situtation1 
         if s.charAt(i) == t.charAt(i)
            continue;
        
        situtation2
        if s.charAt(i) != t.charAt(i)
            move p1 --- Not moving 
            move p2
        
            
        ===================================
        
        aereererererdh => s
        aeredsfsdererdfdsdererdh => t
        
      a b   c   d   e
      a     c       e             is a substring
      a             e   c           is not string 
      ^   ^
      0             25
      0             25
    
    Input: s = "axc", t = "ahbgdc"
       false
     // First approach 
    0 1 2 3 4 ... 25
    1. int[] = 26 
        0 0 0 0 0          ... 0
    
    2. Iterate through t string. Check for charCode 
    // ASCII 97 - 123
    - t.charAt(i) - 'a'
    
    1 1 1 1 e f 1 1 fdsfsfdss
    
    3. Iterate through s string 
        check 
        if s.charAt(i) != 1 
            break out from the loop and return false
        else
            continue;
    // 
    4. return true;    
        
*/