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
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {

        if(root==null) return null;

        TreeNode curr=root;

        if(curr.val==val){
            return root;
        }

        else if(curr.val>val){
           return searchBST(curr.left,val);
        }
        else{
            return searchBST(curr.right,val);

        }
        
    }
}
