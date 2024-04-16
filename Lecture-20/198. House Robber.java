class Solution {
    public int rob(int[] nums) {
        // return usingDP(nums);
        return optimize(nums);
    }
    
    public int usingDP(int a[]){
        int n=a.length, dp[] = new int[n];
        if(n==1)    return a[0];

        dp[0]=a[0];
        dp[1]=Math.max(dp[0],a[1]);
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1],a[i]+dp[i-2]);
        }
        return dp[n-1];
    }
    
    public int optimize(int a[]){
        int pp=0, p=0;
        for(int i:a){
            int now = Math.max(i+pp,p);
            pp=p;
            p=now;
        }
        return p;
    }
}
