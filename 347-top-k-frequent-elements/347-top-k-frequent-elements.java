class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        /*
            Key     Value
            1       3
            2       2
            3       1
        */
        // https://www.geeksforgeeks.org/difference-between-min-heap-and-max-heap/
        // https://stackoverflow.com/questions/11003155/change-priorityqueue-to-max-priorityqueue
        // (a,b) -> map.get(b) - map.get(a) is a lambda expression, Also known as a comparator.

        // It's defining the 'priority' of the queue to be whichever number ( a or b ) is bigger.

        // It works like this...

        // If (a,b) -> map.get(b) - map.get(a) - It will start adding elements with their freq in decreasing order (in this case, it will be 3 2 1 (freq))
        // if (a,b) -> map.get(a) - map.get(b) - It will start adding element with their freq in increasing order (in this case, it will be 1 2 3 (freq))
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        //Go through the map and add it to the maxHeap
        for(int key : map.keySet()){
            maxHeap.add(key);
        }
        /*
        Max Heapify
                1
        ------------------------
                1
               /
              1
              
       -------------------------
                1
               / \
              1   1
      --------------------------
               2
              / \
             1   1
            /
           1
     --------------------------
            2
           / \
          2   1
        /   \
       1     1 
     --------------------------
                3
              /  \
             2    2
            / \  /
           1   1 1 
   
             
        */
        // We only want k elements, therefore poll them from the maxHeap
        // Retrieves and removes the head of this queue, or returns null if this queue is empty.
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = maxHeap.poll();
        }
        return result;
    }
}

/*
https://leetcode.com/problems/top-k-frequent-elements/discuss/1927648/One-OF-THE-best-EXPLANATION
//==============================
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        map.put(1,5);
        map.put(3,8);
        map.put(2,4);
        map.put(4,7);
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue((a,b) -> map.get(b) - map.get(a));
        
        for(int key : map.keySet()) maxHeap.add(key);
        
        System.out.println(maxHeap);
    }
}

*/