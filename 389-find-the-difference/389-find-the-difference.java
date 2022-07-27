/*
Time - O(n)
Space - O(s.length())
*/
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