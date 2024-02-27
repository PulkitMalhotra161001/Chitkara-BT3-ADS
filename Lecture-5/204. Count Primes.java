class Solution {
    public int countPrimes(int n) {
        if(n<2) return 0;
        
        boolean prime[] = new boolean[n+1];
        Arrays.fill(prime,true);
        prime[0]=false;
        prime[1]=false;
        
        
        for(int i=2;i<=(int)Math.sqrt(n)+1;i++){
            if(prime[i]){
                for(int j=i*i;j<=n;j+=i){
                    prime[j]=false;
                }
            }
        }
        
        int ans=0;
        for(int i=0;i<n;i++){
            if(prime[i])   ans++;
        }
        
        return ans;
        
    }
}
