/*
       1 <= n <= 1000
       
       Two Rules
       
       n = 2
       Alice chooses 1.  2 % 1 == 0
       After Alice choose 1, this number needs to be taken out so that bob cannot chooses
       
       n = 3
       Alice = 1. 2 % 1 == 0
       Bob = 2. 2 % 2 == 0.
       Alice no more. So Alice loose 
       
       
       n = 6
       x = 1
           1    2   4   
        
        n = 6 -1 = 5
            5 - 1 = 4
            4 - 1 = 3
            
        n = 6 
            6 - 2 = 4
            4 
    
        n = 3;
        
        alice = 2
        n = 1
        bob = 1 3 % 1 == 0
        n = 1- 1= 0
        Alice n
        /
        %
        
        n = 2
        alice = 1, n = 2 - 1= 1
        alice win
        
        n = 3
        alice = 1, n = 3 - 1 = 2
        bob = 1, n = 2 -1 = 1
        alice loose
        
        
        n = 4
        When n is even, 
        alice = 1, n = 4 - 1= 3
        bob = 1, n = 3 - 1= 2
        alice = 1, n = 2 - 1 = 1   0 < x < 1 
        no more move for bob
        alice win!!
        -------------------------
        alice = 2, n = 4 - 2 = 2
        bob = 1, n = 2 - 1 = 1
        Therefore, alice cannot choose 2 in this case
        
        n = 5
        alice = 1, n = 5 - 1= 4
        bob = 
        alice loose
        
        n = 6 
        alice = 1, n = 6 - 1 = 5 win
        alice = 2, n = 6 - 2 = 4 loose 
        alice = 3 , n = 6 - 3 = 3 win
        bob = 
        
        n = 7 
        alice = 1
*/          

class Solution {
    public boolean divisorGame(int n) {
      return n % 2 == 0;
        
    }
}















