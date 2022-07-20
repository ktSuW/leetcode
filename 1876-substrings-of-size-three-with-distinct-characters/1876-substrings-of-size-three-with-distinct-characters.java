class Solution {
    public int countGoodSubstrings(String s) {
 
        int result = 0;
        
        // Add -2 to the length() to ensure end can move till the end of the array
        for(int i=0;i<s.length()-2;i++){
            // if(i+3 > s.length()) break;
            Set<Character> set = new HashSet<>();
            for(int j=i;j<i+3;j++){
                set.add(s.charAt(j));
            }
            if(set.size()==3){
                result++;
            }
        }
        return result;
    }
}