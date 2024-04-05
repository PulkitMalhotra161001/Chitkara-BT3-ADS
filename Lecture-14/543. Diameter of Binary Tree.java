class Solution {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans=0;
        height(root);
        return ans;
    }
    int height(TreeNode root){
        if(root==null)  return 0;
        int left = height(root.left);
        int right = height(root.right);
        // System.out.println(root.val+" => "+left+" "+right);
        ans=Math.max(ans, left+right);
        return 1+Math.max(left,right);
    }
}
