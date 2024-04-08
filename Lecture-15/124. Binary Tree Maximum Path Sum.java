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
    int ms=-100000;
    public int sol( TreeNode root){
        if(root==null){
            return 0;
        }
        int t=root.val;
    
        int left=Math.max(0 , sol( root.left));
        int right=Math.max(0 , sol( root.right));
        //int right=sol( );

        ms=Math.max((left+right+t) , ms);

        //System.out.println(ms);
        return Math.max(left , right)+t;
    }
    public int maxPathSum(TreeNode root) {
        //int sum=0
        
        int sum=sol(root);
        return  ms;
    }
}
