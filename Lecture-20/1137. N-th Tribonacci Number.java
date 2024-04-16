class Solution {
    public int tribonacci(int n) {
        int dp[] = new int[n+1];
        // return using_rec(n,dp);
        // return using_tab(n,dp);
        
        return optimize(n);
    }
    
    int optimize(int n){
        if(n==0)    return 0;
        if(n==1)    return 1;
        if(n==2)    return 1;
        
        int first = 0;
        int second = 1;
        int third = 1;
        
        for(int i=3;i<=n;i++){
            int now = first + second + third;
            
            first = second;
            second = third;
            third = now;
        }
        
        return third;
    }
    
    int using_tab(int n,int dp[]){
        if(n==0)    return 0;
        if(n==1)    return 1;
        if(n==2)    return 1;
        
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        
        for(int i=3;i<=n;i++){
            // dp[n] = using_rec(n-1,dp) + using_rec(n-2,dp) + using_rec(n-3,dp)
            dp[i]  = dp[i-1] + dp[i-2] + dp[i-3];
        }
        
        return dp[n];
    }
    
    int using_rec(int n,int dp[]){
        if(dp[n]>0) return dp[n];
        if(n==0)    return dp[n] = 0;
        if(n==1)    return dp[n] = 1;
        if(n==2)    return dp[n] = 1;
        
        // System.out.println(n);
        return dp[n] = using_rec(n-1,dp) + using_rec(n-2,dp) + using_rec(n-3,dp);
    }
}
