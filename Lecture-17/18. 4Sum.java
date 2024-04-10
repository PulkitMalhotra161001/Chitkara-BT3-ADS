class Solution {
    public List<List<Integer>> fourSum(int[] a, int target) {
        Arrays.sort(a);
        
        int n = a.length;
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=0;i<=n-4;i++){
            
            //ignore same value
            if(i>0 && a[i]==a[i-1]) continue;
            
            for(int j=i+1;j<=n-3;j++){

                //ignore same value
                if(j>i+1 && a[j]==a[j-1]) continue;
                
                long first = (long)a[i], second = (long)a[j];
                
                int l=j+1, r=n-1;
                while(l<r){
                    long sum = first + second + (long)a[l] + (long)a[r];
                    
                    if(sum==target){
                        
                        //save it
                        List<Integer> temp = new ArrayList<>();
                        temp.add(a[i]);
                        temp.add(a[j]);
                        temp.add(a[l]);
                        temp.add(a[r]);
                        
                        ans.add(temp);
                        
                        l++;
                        r--;
                        
                        //ignore same value
                        while(l<r && a[l]==a[l-1])  l++;
                        while(l<r && a[r]==a[r+1])  r--;
                    }else if(sum>target){
                        
                        //it sum is greater we have to reduce that
                        r--;
                    }else{
                        
                        //it sum is less we have to increase that
                        l++;
                    }
                }
            }
        }
        
        return ans;
    }
}
