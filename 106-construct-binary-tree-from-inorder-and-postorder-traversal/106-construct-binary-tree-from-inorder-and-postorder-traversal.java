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
inorder =   [9,3,15,20,7] left root right 
postorder = [9,15,7,20,3]   left right root 
In post order, root is visited last. 

*/
class Solution {
    HashMap<Integer, Integer> inorderMap = new HashMap<>();
    int postOrderIndex;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i < inorder.length; i++ ){
            inorderMap.put(inorder[i], i);
        }
       postOrderIndex = postorder.length -1;
       return buildTree(inorder, postorder, 0, postOrderIndex);
    }
    
    private TreeNode buildTree(int[] inorder, int[] postorder, int start, int end){
        // base case
        if(start > end) return null;
        // needs to starts from the end of the postorder array since it is the root

        TreeNode root = new TreeNode(postorder[postOrderIndex--]);
        
        if(root == null) return null;
        if(start == end) return root;
        
        int index = inorderMap.get(root.val);
        // Right must be visited first. 
        // Because post order visiting order is => left right root
        // Now we are visiting in reversed order since from reversed order, we can get the root.
        // Therefore left right root becomes
        //           root left right
        // Therefore, root.right must come first, otherwise, the tree reconstruction will be incorrect
        root.right = buildTree(inorder, postorder, index + 1, end);       
        root.left = buildTree(inorder, postorder, start, index -1);

        return root;
    } 
}




















