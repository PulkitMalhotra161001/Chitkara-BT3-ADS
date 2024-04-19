/*
 * N bottles of wine
 * each year profit gets x time
 * 1 year [2,4,6,2,5]
 * 2 year [4,8,12,4,10]
 * n year [2n,4n,6n,2n,5n]
 * 
 * one bottle sold per year from either END
 * GOAL - maximum profit
 */

class wine_problem{
    public int findProfit(int a[]){
        int n = a.length;
        Integer dp[][] = new Integer[n][n];
        return solve(0,n-1,n,a,dp);
    }
    int solve(int l,int r,int n,int a[],Integer dp[][]){
        if(l>r) return 0;
        if(dp[l][r]!=null)  return dp[l][r];

        int year = n - (r - l);
        //one bottle
        if(l==r)    return a[l]*year;
        
        int left  = a[l]*year + solve(l+1,r,n,a,dp);
        int right = a[r]*year + solve(l,r-1,n,a,dp);

        return dp[l][r] = Math.max(left,right);
    }
}