class Solution{
    static int matrixMultiplication(int n, int p[])
    {
        n--;
        int dp[][]=new int[n][n];
        for(int g=1;g<n;g++){
            for(int i=0,j=g;j<n;i++,j++){
                if(g==1){
                    dp[i][j]=p[i]*p[j]*p[j+1];
                }else{
                    
                    dp[i][j]=Integer.MAX_VALUE;
                    
                    //make cut at kth position
                    for(int k=i;k<j; k++){
                        int left=dp[i][k];
                        int right=dp[k+1][j];
                        int mul=p[i]*p[k+1]*p[j+1];
                        int total=left+right+mul;
                        
                        if(total<dp[i][j]){
                            dp[i][j]=total;
                        }
                        
                    }
                    
                }
            }
        }
        return dp[0][n-1];
    }
}