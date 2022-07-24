class Solution {
    public int[] sortArray(int[] nums) {
        if(nums.length== 0)return nums;
        quickSort(nums, 0, nums.length -1);
        return nums;
    }
    
    public void quickSort(int[] nums, int low, int high){
        if(high <= low)
			return ;
		int middle= low + (high-low)/2;
		int pivot = nums[middle];
		int i=low , j=high;
		
		while( i<=j ) {
			
			while(nums[i] < pivot)
				i++;
			
			while(nums[j] > pivot)
				j--;
			
			if(i<=j) {
				//SWAP
				swap(nums, i, j);
				i++;
				j--;
			}
			
		}
		
		if(low < j)
			quickSort(nums,low,j);
		
		if(i<high)
			quickSort(nums,i,high);
    }
    
    private void swap(int[] nums, int low, int high){
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }
}