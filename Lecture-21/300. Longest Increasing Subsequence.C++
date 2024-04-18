class Solution {
public:
    int solveMem(vector<int>& nums,int curr,int prev,vector<vector<int>> &dp){
        if(curr>=nums.size())
        return 0;

        if(dp[curr][prev+1]!=-1) return dp[curr][prev+1];

        //include
        int include=0;
        if(prev==-1 || nums[curr]>nums[prev]){
            include=1 + solveMem(nums,curr+1,curr,dp);
        }
        //exclude
        int exclude=0+solveMem(nums,curr+1,prev,dp);

        dp[curr][prev+1]=max(include,exclude); //prev+1 because -1 is not a      valid index so by making it valid we just add +1 to prev index
        return dp[curr][prev+1];
    }

    int lengthOfLIS(vector<int>& nums) {
        int curr=0;
        int prev=-1;
        int n=nums.size();

        vector<vector<int> > dp(n,vector<int>(n+1,-1));

        return solveMem(nums,curr,prev,dp);
        
    }
};
