/*
n = 4 
This problem is DP.

            1   
          1    1
           \  /
        1    2   1
         \  /  \/
    1     3     3   1

*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < numRows; i++){
            List<Integer> curr = new ArrayList<>();
            
            for(int j = 0; j <= i; j++){
                // stat is always 1
                // end is always 1 , therefore, add 1
                if(j == 0 || j == i){
                    curr.add(1);
                }else{
                    // above row therefore, i -1
                    // column is always j-1 + j 
                    int a = result.get(i-1).get(j-1);
                    int b = result.get(i-1).get(j);
                    curr.add( a + b);
                }
            }
            result.add(curr);
        }
        return result;
    }
}