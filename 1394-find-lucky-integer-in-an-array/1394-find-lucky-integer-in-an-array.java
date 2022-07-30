class Solution {
    public int findLucky(int[] arr) {
        int largest = -1;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++){
            int k = arr[i];
            if(map.containsKey(k)){
                map.put(k, map.get(k)+1);
            }else{
                map.put(k, 1);
            }
        }
        
        for(Integer key : map.keySet()){
            Integer value = map.get(key);
            if(key == value){
                largest = Math.max(key, largest);
            }
        }
        return largest > - 1 ? largest : -1;
    }
}