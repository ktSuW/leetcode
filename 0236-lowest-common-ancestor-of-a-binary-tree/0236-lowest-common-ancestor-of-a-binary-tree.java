/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
            1
        2          3
  4        5     8    9
         6  7 

    node = 4   path     1 , 2, 4     O(n) 
    node = 7   path     1 , 2, 5, 7   O(n)
    
    Traversal DFS traversal
    Find 4. 
    Find 7. Once you find them, you do not need to further search 
    null, 7 => you need to take 7
    If both are not null, you have found lca 
    

*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if(root ==null || root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left == null) return right;
        else if(right == null) return left;
        else 
            // both left and right is not null
            return root;
    }
}