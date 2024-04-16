class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length(), m=t.length();
        Integer dp[][]=new Integer[n][m];
        // return solve(s,t,n-1,m-1,dp);
        // return tab(s,t,n,m);
        // return spaceOptimize(s,t,n,m);
        return best(s,t,n,m);
    }
    int solve(String a,String b,int i,int j,Integer dp[][]){
        //means b stirng found
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=null)  return dp[i][j];
        //found
        if(a.charAt(i)==b.charAt(j)){
            //match reamining or not take this
            return dp[i][j] = solve(a,b,i-1,j-1,dp) + solve(a,b,i-1,j,dp);
        }
        return dp[i][j] = solve(a,b,i-1,j,dp);
    }
    int tab(String a,String b,int n,int m){
        
//         int dp[][] = new int[n][m];
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(a.charAt(i)==b.charAt(j)){
//                     dp[i][j] = (j-1<0?1:i-1<0?0:dp[i-1][j-1]) + (i-1<0?0:dp[i-1][j]);
//                 }else{
//                     dp[i][j] = (i-1<0?0:dp[i-1][j]);
//                 }
//             }
//         }
        
//         return dp[n-1][m-1];
        
        int dp[][] = new int[n+1][m+1];
        
        for(int i=0;i<n;i++)    dp[i][0]=1;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][m];
    }
    
    int spaceOptimize(String a,String b,int n,int m){
        int cur[] = new int[m+1], prev[] = new int[m+1];
        
        prev[0]=1;
        cur[0]=1;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    cur[j] = prev[j-1] + prev[j];
                }else{
                    cur[j] = prev[j];
                }
            }
            
            prev = cur;
            cur = new int[m+1];
            cur[0]=1;
        }
        
        return prev[m];
    }
    
    int best(String a,String b,int n,int m){
        int prev[] = new int[m+1];
        
        prev[0]=1;
        
        for(int i=1;i<=n;i++){
            for(int j=m;j>=1;j--){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    prev[j] = prev[j-1] + prev[j];
                }else{
                    prev[j] = prev[j];
                }
            }
            
        }
        
        return prev[m];
    }
}
