class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // return DP(cost);
        // return spaceOptimize(cost);
        return noSpace(cost);
    }
    public int noSpace(int[] cost){
        int n=cost.length;
        int pp = cost[0];
        int prev = cost[1];
        
        if(n<=2) return Math.min(pp,prev);
        
        for(int i=2;i<n;i++){
            int now = cost[i] + Math.min(prev,pp);
            pp = prev;
            prev = now;
        }
        
        return Math.min(prev,pp);
    }
    public int spaceOptimize(int[] cost) {
        int n=cost.length;
        for(int i=2;i<n;i++){
            cost[i] = cost[i] + Math.min(cost[i-1],cost[i-2]);
        }
        return Math.min(cost[n-1],cost[n-2]);
    }
    public int DP(int cost[]){
        int n=cost.length;
        int dp[]=new int[n];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<n;i++){
            dp[i]=cost[i]+Math.min(dp[i-2],dp[i-1]);
        }
        return Math.min(dp[n-1],dp[n-2]);
    }
}
