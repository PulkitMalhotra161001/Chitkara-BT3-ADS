class Solution {
public:
 
    // 2nd way to do it
    int helper(TreeNode *root , int t){
        if(!root) return 0 ;

        return helper(root->left , t)+helper(root->right , t)+helper2(root , t);
    }
   long long int helper2(TreeNode *root , long long int t){
        if(!root) return 0;
        int c=0;
        if(root->val==t) c=1;
        c+=helper2(root->left , t-root->val);
        c+=helper2(root->right , t-root->val);

        return c;
    }
    int pathSum(TreeNode* root, int targetSum) {
        int ans=0;
    
        return helper(root , targetSum);
    }
};
