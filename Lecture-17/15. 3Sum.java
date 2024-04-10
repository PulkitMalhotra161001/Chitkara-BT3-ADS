class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        int k=0;
        
        for(int i=0;i<=n-3;i++){
            //we have to consider distinct value
            if(i>0 && nums[i]==nums[i-1])   continue;
            
            int l=i+1, r=n-1;
            while(l<r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum==k){
                    ans.add(Arrays.asList(nums[i] , nums[l] , nums[r]));
                    
                    //ignore duplicate values
                    while(l<r && nums[l]==nums[l+1])  l++;
                    
                    //ignore duplicate values
                    while(l<r && nums[r-1]==nums[r])  r--;
                    l++;
                    r--;
                }
                
                //if sum is more we have to reduce that
                else if(sum>k)  r--;
                
                //if sum is less we have to increase that
                else    l++;
            }
            
        }
        return ans;
    }
}
