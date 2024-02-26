class Solution {
    public int maxSubArray(int[] nums) {
        int ans=Integer.MIN_VALUE, cur=0;
        
        for(int i:nums){
            cur = Math.max(cur+i,i);
            ans = Math.max(ans,cur);
        }

        return ans;
    }
}
