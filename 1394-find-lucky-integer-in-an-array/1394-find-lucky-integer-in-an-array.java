/*
Use hashmap to stroe key and frequencies of each element
    K   V
    1   1
    2   2
    3   3
   
 Iterate through hashmap and check for largest frequencies 
 And return it.

*/

class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
          if(hash.containsKey(arr[i])){
              hash.put(arr[i], hash.get(arr[i]) +1);
          }else{
              hash.put(arr[i], 1);
          }
        }
        // System.out.println(hash);
        int largest = -1;
        for(Integer key : hash.keySet()){
            Integer value = hash.get(key);
            if(key == value){
                largest = Math.max(key, largest);
            }
        }
        return largest > -1 ? largest : -1;
    }
}

