/*  
        low = l
        high = h
        p = pivot
        ------------------
        
        l    p          h
        5   4   3   2   1
        
            l       h
        1   4   3   2   5
        
                l,h
        1   2   3   4   5
        
        Now, pivot is in correct position

    1   2   3   
        
        How to find the violation condition
        while nums[l] < pivot , keep moving
        while nums[h] > pivot , keep moving - decrease e
        
      start     l,h     end
        1   2   3   4   5
        
        For recursive partitioning
    
    start       h   l end
        1   2   3   4   5
        
        range will be 
            => start to high
            => low to end 
        
  Time (nlogn) - Average case
        n^2    - worst case

    space O(n) in place swapping => compared to Merge sort

*/
class Solution {
    public int[] sortArray(int[] nums) {
        if(nums.length== 0)return nums;
        quickSort(nums, 0, nums.length -1);
        return nums;
    }
    
    public void quickSort(int[] nums, int low, int high){
        if(low >= high) return;
        int s = low;
        int e = high;
        int mid = s + (e - s)/2;
        int pivot = nums[mid];
        
        while(s <= e){
            while( s<= e && nums[s] < pivot){
                s++;
            }
            while(s<= e && nums[e] > pivot){
                e--;
            }
            
            if(s <= e){
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }
        // now the pivot is at the correct index
        // sort two half 
        quickSort(nums, low, e);
        quickSort(nums, s, high);
        
    }
}

