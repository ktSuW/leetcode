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
    
    PriorityQueue<Integer> maxheapFirsthalf = new PriorityQueue(Collections.reverseOrder());
    PriorityQueue<Integer> minheapSecondhalf = new PriorityQueue();
    
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        maxheapFirsthalf.add(num);
        minheapSecondhalf.add(maxheapFirsthalf.poll());
        if(maxheapFirsthalf.size() < minheapSecondhalf.size()){
            // this way max will always be larger if they are not equal 
            maxheapFirsthalf.offer(minheapSecondhalf.poll());
        }
    }
    
    public double findMedian() {
        if(maxheapFirsthalf.size() == minheapSecondhalf.size()){
            // 2.0 to get the double type 
            return (maxheapFirsthalf.peek() + minheapSecondhalf.peek())/ 2.0;
        }else{
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