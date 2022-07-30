class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        int[] sC = new int[26];
        int[] tC = new int[26];
        
        for(int i = 0; i < s.length(); i++){
            sC[s.charAt(i) - 'a'] += 1;
            tC[t.charAt(i) - 'a'] += 1;
        }
        
        for(int i = 0; i < 26; i++){
            if(sC[i] != tC[i]){
                // System.out.println(sC[i]);
                // System.out.println(tC[i]);
                // System.out.println("========");
                return false;
            }
        }
        return true;
    }
}