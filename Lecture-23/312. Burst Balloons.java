class Solution {
    public int maxCoins(int[] nums) {
        // return solve(nums,0,nums.length-1,new Integer[nums.length][nums.length],nums.length);
        return tab(nums,nums.length);
    }
    int solve(int a[],int l,int r,Integer dp[][],int n){
        if(l>r) return 0;
        if(dp[l][r]!=null)  return dp[l][r];
        
        //suppose we burst ith ballon last
        for(int i=l;i<=r;i++){
            
            //multiply with left and right value
            int temp = (l-1<0?1:a[l-1])*a[i]*(r+1>=n?1:a[r+1]);
            
            //solve for left and right
            temp+=solve(a,l,i-1,dp,n) + solve(a,i+1,r,dp,n);
            
            //store max
            dp[l][r]=Math.max(dp[l][r]==null?0:dp[l][r],temp);
        }
        return dp[l][r];
    }
    int tab(int a[],int n){
        int dp[][] = new int[n][n];
        for(int l=n-1;l>=0;l--){
            for(int r=0;r<n;r++){
                if(l>r) continue;
                for(int i=l;i<=r;i++){
            
                    //multiply with left and right value
                    int temp = (l-1<0?1:a[l-1])*a[i]*(r+1>=n?1:a[r+1]);

                    //solve for left and right
                    temp+=(i-1<0?0:dp[l][i-1]) + (i+1>=n?0:dp[i+1][r]);

                    //store max
                    dp[l][r]=Math.max(dp[l][r],temp);
                }
            }
        }
        
        return dp[0][n-1];
    }
}
