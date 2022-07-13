/*
We can still use Binary search template.
1. Find out total rows and total columns number of the matrix
2. In this step, we can find the row the target lies
    e.g. 1  3   5   7
         10 11  16  20
         23 30  34  60
        
    target is 3.
    To find out the potential rows, do binary search for all rows
    
    initialise rowStart = 0;
               rowEnd = matrix[0].length -1;
    while(rowStart < rowEnd)
        find out mid value
    Case 1: if the target is greater than or == that row - first value 
             and less than or equal to last value
        Then we are guranteed that target is within this row.
3. We can do binary search for the columns items since they are sorted.
4. Case 2 : target is less than the beginning of that row, means you need to move rowEnd to mid -1;
5. Case 3 : target is greater than the last element of that row, means you need to move rowStart to mid + 1;
6. At the end of the while loop, if you cannot find it, return false;

*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int totalRows = matrix.length - 1;
        int totalCols = matrix[0].length -1;
        
        //Binary search on rows to see if the target lies within that particular row
        int rStart = 0;
        int rEnd = totalRows;
        
        while(rStart <= rEnd){
            // find mid row of the matrix 
            int mid = rStart + (rEnd - rStart)/2;
            // Check if the target is within this row
            if(target >= matrix[mid][0] && target <= matrix[mid][totalCols]) {
                // we have confirmed that target value lies within this row range
                // binary search for the cols
                int cStart = 0;
                int cEnd = totalCols;
                while(cStart <= cEnd){
                    int cMid = cStart + (cEnd - cStart)/2;
                    if(target == matrix[mid][cMid]){
                        return true;
                    }else if (target < matrix[mid][cMid]){
                        cEnd = cMid -1;
                    }else{
                        cStart = cMid + 1;
                    }
                }
                return false;
            }else if(target < matrix[mid][0]){
                rEnd = mid -1;
            }else {
                rStart = mid + 1;
            }
        }
        return false;
    }
}