class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int l=0, r=stalls[n-1]-stalls[0], ans=0;
        while(l<=r){
            int mid = l+(r-l)/2;
            int c = cows(stalls,mid,n);
            if(c>=k){
                ans=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
            // System.out.println(mid+" "+c);
            
        }
        return ans;
    }
    static int cows(int a[],int d,int n){
        // int i=0, j=1, ans=1;
        // while(j<n){
        //     if(a[j]-a[i]<=d)    j++;
        //     else{
        //         i=j;
        //         j++;
        //         ans++;
        //     }
        // }
        // return ans;
        
        int temp=0;
		int prev=-1;
		for(int i=0;i<n;i++) {
			if(prev==-1 || a[i]-prev>=d) {
				temp++;
				prev=a[i];
			}
		}
        return temp;
    }
}
