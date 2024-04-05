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
    int moves_required;
    public int distributeCoins(TreeNode root) {
        moves_required = 0;
        findMoves(root);
        return moves_required;
    }
    int findMoves(TreeNode node){
        if(node==null)  return 0;
        
        //requirement or moves
        int left_requirement = findMoves(node.left);
        int right_requirement = findMoves(node.right);
        moves_required += Math.abs(left_requirement) + Math.abs(right_requirement);
        
        int total_coins_here = node.val + left_requirement + right_requirement;
        
        //we want atmost one coin here (so to balance we remove excess coins)
        return total_coins_here - 1;
    }
}
