/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/*
// Recursive approach
        4
    /     \
   2       7
 /  \    /   \
 1  3    6   9
 
 I need to swap
 root is 4
 root.left = 2
 root.right = 7
 So swap......
 Get the root.left 
 root.right 
 And then swap. 
    root = 4
    left = invertTree(root.left) 2
    call itself, 
    root = 2
    left = invertTree(root.left) 1
    callitself 
    root = 1
    left = invertTree(root.left) null
    Now, I have reached the base case......
    
    right = iT(root.right) null 
    so null = null 
    public TreeNode invertTree(TreeNode root) {
        //Recursive Approach
        if(root == null) return null;
        TreeNode left = invertTree(root.left);
        // System.out.println("left :" + left );
        TreeNode right = invertTree(root.right);
        // System.out.println("right :" + right );
        root.left = right;
        root.right = left;
        // System.out.println("After swapping left :" + left + " and right : " + right);
        return root;
    }
    
 
 // Iterative 
 Since each node are swapped at each level, I could use BFS traversal approach
 
   queue 4 
       curr = 4
       temp = 2
       7 = 2
       
   2  7
   
   queue.poll = 2
   3 = 1
   
   queue.poll = 7 
   9 = 8
*/
class Solution {
    public TreeNode invertTree(TreeNode root) {
        //Iterative Approach
        // Using BFS so queue will be used
        if(root == null) return null;
        // Queue
        Queue<TreeNode> queue = new ArrayDeque<>();
        // 4 
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            TreeNode temp = curr.left;
            // swap
            curr.left = curr.right;
            curr.right = temp;
            
            if(curr.left != null) queue.add(curr.left);
            if(curr.right != null) queue.add(curr.right);
            
        }
        return root;

    }
}