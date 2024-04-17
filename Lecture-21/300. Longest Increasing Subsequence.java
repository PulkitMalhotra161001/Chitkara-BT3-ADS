class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        //create_all_Subsequence then find the longest increasing O(2^n)
        // return memo(0,-1,nums,n,new Integer[n+1][n+1]);
        // return tab(nums,n,new int[n+1][n+1]);
        // return tab(nums,n);
        return optimizeSpace(nums,n);
        // return using_BS(nums);
    }
    int optimizeSpace(int a[],int n){
        //if you want to trace back LIS just maintain a new array which represent the prev idx
        int dp[] = new int[n], max=1;
        Arrays.fill(dp,1);
        
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(a[j]<a[i]){
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
    int tab(int a[],int n){
        int next[] = new int[n+1], cur[] = new int[n+1];
        
        for(int i=n-1;i>=0;i--){
            for(int prev=i-1;prev>=-1;prev--){
                int ans = next[prev+1];
                if(prev==-1 || a[prev]<a[i]){
                    ans = Math.max(ans, 1+ next[i+1]);
                }
                                   
               cur[prev+1] = ans;
            }
            next = cur;
            cur = new int[n+1];
        }
        
        return next[-1+1];
    }
    int tab(int a[],int n,int dp[][]){
        // 0 -> n-1
        for(int i=n-1;i>=0;i--){
            for(int prev=i-1;prev>=-1;prev--){
                int ans = dp[i+1][prev+1];
                if(prev==-1 || a[prev]<a[i]){
                    ans = Math.max(ans, 1+ dp[i+1][i+1]);
                }
                                   
               dp[i][prev+1] = ans;
            }
        }
        
        return dp[0][-1+1];
    }
    int memo(int i,int prev,int a[],int n,Integer dp[][]){
        if(i==n)    return 0;
        if(dp[i][prev+1]!=null) return dp[i][prev+1];
        
        //not_take
        int ans = memo(i+1,prev,a,n,dp);
        
        if(prev==-1 || a[prev]<a[i]){
            ans = Math.max(ans, 1+ memo(i+1,i,a,n,dp));
        }
        
        return dp[i][prev+1] = ans;
    }
    
    int using_BS(int nums[]){
        List<Integer> al = new ArrayList<>();
        for(int i:nums){
            add(al,i);
        }
        return al.size();
    }
    void add(List<Integer> list,int x){
        int l=0, r=list.size()-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(list.get(mid)<x) l=mid+1;
            else    r=mid-1;
        }
        
        if(l==list.size())  list.add(x);
        else    list.set(l,x);
    }
}   
