class Solution {
    public int sumNumbers(TreeNode root) {
        return sol(root,0);
    }
    public int sol(TreeNode node,int total){
         if (node != null) {
            total = total * 10 + node.val;

            if (node.left == null && node.right == null) {
                return total;
            }
            
            int leftSum = sol(node.left, total);
            int rightSum = sol(node.right, total);
            
            return leftSum + rightSum;
        } else {
            return 0;
        }

    }
}
