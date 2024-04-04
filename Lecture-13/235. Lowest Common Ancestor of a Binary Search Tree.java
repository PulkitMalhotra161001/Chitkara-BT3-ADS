class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root.val==p.val || root.val==q.val)    return root;
        
        if(p.val>q.val)  return lowestCommonAncestor(root,q,p);
        
        
        if(p.val<root.val && root.val<q.val)    return root;
        if(p.val<root.val && q.val<root.val)    return lowestCommonAncestor(root.left,p,q);
        return lowestCommonAncestor(root.right,p,q);
    }
}
