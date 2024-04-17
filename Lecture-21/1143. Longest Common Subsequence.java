class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length(), m=text2.length();
        // return memo(0,0,n,m,text1,text2,new Integer[n][m]);
        // return memo(n,m,text1,text2,new Integer[n+1][m+1]);
        // return tab(n,m,text1,text2,new int[n+1][m+1]);
        return tab(n,m,text1,text2);
    }
    /*
    int memo(int i,int j,int n,int m,String a,String b,Integer dp[][]){
        if(i==n || j==m)    return 0;
        if(dp[i][j]!=null)  return dp[i][j];
        if(a.charAt(i)==b.charAt(j))    return dp[i][j]=1+memo(i+1,j+1,n,m,a,b,dp);
        return dp[i][j] = Math.max( memo(i+1,j,n,m,a,b,dp), memo(i,j+1,n,m,a,b,dp) );
    }
    */
    int memo(int i,int j,String a,String b,Integer dp[][]){
        if(i==0 || j==0)    return 0;
        if(dp[i][j]!=null)  return dp[i][j];
        if(a.charAt(i-1)==b.charAt(j-1))    return dp[i][j]=1+memo(i-1,j-1,a,b,dp);
        return dp[i][j] = Math.max( memo(i-1,j,a,b,dp), memo(i,j-1,a,b,dp) );
    }
    int tab(int n,int m,String a,String b,int dp[][]){
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a.charAt(i-1)==b.charAt(j-1))    dp[i][j]= 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max( dp[i-1][j], dp[i][j-1] );
            }
        }
        
        return dp[n][m];
        
    }
    
    int tab(int n,int m,String a,String b){
        int cur[] = new int[m+1], prev[] = new int[m+1];
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a.charAt(i-1)==b.charAt(j-1))    cur[j]= 1 + prev[j-1];
                else cur[j] = Math.max( prev[j], cur[j-1] );
            }
            
            prev = cur;
            cur = new int[m+1];
        }
        
        return prev[m];
    }
}
