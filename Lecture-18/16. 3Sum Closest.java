class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length, ans=Integer.MAX_VALUE, diff=Integer.MAX_VALUE;
        for(int i=0;i<=n-3;i++){
            int l=i+1, r=n-1;
            while(l<r){
                int sum  = nums[i] + nums[l] + nums[r];
                
                int d = Math.abs(sum-target);
                
                if(d<diff){
                    diff = d;
                    ans = sum;
                }
                
                if(sum==target){
                    l++;
                    r--;
                }else if(sum>target){
                    r--;
                }else{
                    l++;
                }
            }
        }
        
        return ans;
    }
}
