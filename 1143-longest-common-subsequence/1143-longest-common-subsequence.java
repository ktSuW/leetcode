/*
Recurrence relationship
Express in index
Explore possibility of that index 
Take the best among them

NOTE
- single index cannot express both strings
 a  c   d           c   e   d
        ^                   ^  subLen = 1
if(s1[index1] == s2[index2])
    1 + f(index1 -1, index2 -1)
    
 a  c               c   e
    ^                   ^
NOt match 
Explore both possibility 
    - move both index c != e
    - move index1 only, keep index2 as it
    - move index2 only, keep index1 as it
if not match, add 0 = f(index1 -1, index2) , f(index1, index2 -1)


    public int longestCommonSubsequence(String text1, String text2) {
//         int val = lcsRecursive(text1, text2, 0, 0);
//         return val;

    }
//     public int lcsRecursive(String s, String t, int i, int j) {
//         if (i >= s.length() || j >= t.length()) {
//             return 0;
//         }
        
//         if (s.charAt(i) == t.charAt(j)) {
//             return lcsRecursive(s, t, i+1, j+1) + 1;
//         } else {
//             int a = lcsRecursive(s, t, i+1, j);
//             int b = lcsRecursive(s, t, i, j+1);
//             return Math.max(a, b);
//         }
//     }
*/

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        Integer[][] memo = new Integer[text1.length()+1][text2.length()+1] ; 
        return helper( text1 , text2 , 0 , 0 , memo ) ;  
    }

    private int helper( String s1 , String s2 , int idx1 , int idx2 , Integer[][] memo ) {

        if( idx1 >= s1.length() || idx2 >= s2.length() ) return 0 ;

        if( memo[idx1][idx2] != null )
            return memo[idx1][idx2] ;

        int val = 0 ;
        if( s1.charAt(idx1) == s2.charAt(idx2) )
            val = 1 + helper( s1 , s2 , idx1+1 , idx2+1 , memo ) ;
        else {
            val = Math.max(helper(s1,s2,idx1,idx2+1,memo) , helper(s1,s2,idx1+1,idx2,memo)) ;
        }

        memo[idx1][idx2] = val ;
        return val ;
    }
}