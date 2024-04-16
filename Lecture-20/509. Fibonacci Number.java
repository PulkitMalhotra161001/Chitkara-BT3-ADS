class Solution {
    public int fib(int n) {
        int dp[] = new int[n+1];
        // return using_rec(n,dp);
        
        // return using_tab(n,dp);
        
        return optimize(n);
    }
    
    int optimize(int n){
        if(n==0)    return 0;
        
        int first = 0;
        int second = 1;
        
        for(int i=2;i<=n;i++){
            int now = second + first;
            
            first = second;
            second = now;
        }
        
        return second;
    }
    
    int using_tab(int n,int dp[]){
        
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }
    
    
    int using_rec(int n,int dp[]){
        if(n==0)    return 0;
        if(n==1)    return 1;
        
        //memo return 
        if(dp[n]>0) return dp[n];
        
        System.out.println(n);
        
        return dp[n] = using_rec(n-1,dp) + using_rec(n-2,dp);
    }
}

//rec
//rec - dp - memo (stack space/ rec calls)
//dp - while/for - tabulation [][]
//1d
//2 variable
