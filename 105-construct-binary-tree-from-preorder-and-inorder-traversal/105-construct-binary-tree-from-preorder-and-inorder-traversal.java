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
preoder visit order => root left right
inorder visit order => left root right 

First check root in the preorder 
Then check in inorder. everything on the left of the root will be visited 

preorder = [3,9,20,15,7] root left right 
inorder =  [9,3,15,20,7] left root right

            3
          /   \
         9      20
               /  \
              15   7
    
preorder 3 will always be the root. Therefore, this tree starts with root.

Find this root, 3, in the inorder. 
- All the nodes on the left side of 3, will be on the left subtree
- All the nodes on the right side of 3, will be on the right subtree

So it will be like this
                3
               /   \
            [9]   [15,20,7]
            
Go and check 9 in the preorder 
            3
           /  \
          9   [15, 20, 7]
Left subtree is done

In the preorder check for 20.
In the inorder check where is 20
            
            20
          /   \
        15     7   

Pseudocode 
    first index of preorder will always be the root.
    Find out where that element is in the inorder
    
    Use Hashmap to store the inorder value as key and position index as value 
    Then recursively call the left subtree and rightsubtree to reconstruct 
*/
class Solution {
    Map<Integer, Integer> inorderMap = new HashMap<>();
    int preorderIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Iterate through inorder array 
        // for lookup, it will be only constant 
        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        /*
            inorderMap
            Key   Value
            ============
            9       0
            3       1
            15      2
            20      3
            7       4
        */
        return buildTree(preorder, inorder, 0, inorder.length -1);
    }
    
    private TreeNode buildTree(int[] preorder, int[] inorder, int start, int end){
        //Base case
        if(start > end) return null;
        TreeNode root = new TreeNode(preorder[preorderIndex++]);
        
        if(root == null) return null;
        if(start == end) return root;
        
        int index = inorderMap.get(root.val);
        // Now we get the index so we can split into left subtree and right subtree based on the root from preorder
        // e.g. left subtree  [9]   
        // e.g. right subtree [15, 20, 7]  
        root.left = buildTree(preorder, inorder, start, index-1);
        root.right = buildTree(preorder, inorder, index+1, end);
        return root;
    }
}












