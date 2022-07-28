/*
Brute Force 
- sort the array everytime - Time O(n^2)
*/ 

class MedianFinder {
    // 5 2 3    1   6 4 7 => before 
    // 1 2 3    4   5 6 7 
    // -----        ----------
    // first half   second half
    // Sort heapify 
    // We want max value from first half => therefore first half is max heap
    // We want min value from first half => therefore second half is min heap
    
    PriorityQueue<Integer> maxheapFirsthalf;
    PriorityQueue<Integer> minheapSecondhalf ;
    
    public MedianFinder() {
        maxheapFirsthalf = new PriorityQueue(Collections.reverseOrder());
        minheapSecondhalf = new PriorityQueue();
    }
    
    public void addNum(int num) {
        // maxheapFirsthalf.add(num);
        // minheapSecondhalf.add(maxheapFirsthalf.poll());
        // if(maxheapFirsthalf.size() < minheapSecondhalf.size()){
        //     // this way max will always be larger if they are not equal 
        //     maxheapFirsthalf.offer(minheapSecondhalf.poll());
        // }
        
        //=====================
        // better more readable code
        if(maxheapFirsthalf.isEmpty() || maxheapFirsthalf.peek() > num){
            maxheapFirsthalf.add(num);
        }else{
            minheapSecondhalf.add(num);
        }
        // check for size difference between these two queues
        // difference will never be more than 1
        if(maxheapFirsthalf.size() > minheapSecondhalf.size() + 1){
            // push min top into max
            // after that remove min top 
            minheapSecondhalf.offer(maxheapFirsthalf.poll());
        }else if (maxheapFirsthalf.size() +1 < minheapSecondhalf.size() ){
            maxheapFirsthalf.offer(minheapSecondhalf.poll());
        }
    }
    
    public double findMedian() {
        if(maxheapFirsthalf.size() == minheapSecondhalf.size()){
            // 2.0 to get the double type 
            return (maxheapFirsthalf.peek() + minheapSecondhalf.peek())/ 2.0;
        }else if(maxheapFirsthalf.size() < minheapSecondhalf.size()){
            return minheapSecondhalf.peek();
        } else{
            return maxheapFirsthalf.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */