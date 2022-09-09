class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int evenP = 0;
        int oddP = 1;
        int n = nums.length;
        while(evenP < n && oddP < n){
            while(evenP < n && nums[evenP] % 2 == 0){
                evenP += 2;
            }
            while(oddP < n && nums[oddP] % 2 != 0){
                oddP += 2;
            }
            if(evenP < n && oddP < n){
                int temp = nums[evenP];
                nums[evenP] = nums[oddP];
                nums[oddP] = temp;
            }
        }
        return nums;
        
    }
}