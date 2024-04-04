class Solution {
    bool helper(TreeNode* root,long long mini,long long maxi){
        if(root==nullptr) return true;
        
        
        if(root->val <= mini or root->val >= maxi) return false;
        
        return helper(root->left,mini,root->val) and helper(root->right,root->val,maxi);
    }
public:
    bool isValidBST(TreeNode* root) {
        return helper(root,LONG_MIN,LONG_MAX);
    }
};
