class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int ans_max=Integer.MIN_VALUE, ans_min=Integer.MAX_VALUE;
        int cur_max=0, cur_min=0;
        int total=0;
        
        for(int i:nums){
            total+=i;
            
            cur_max = Math.max(cur_max+i,i);
            ans_max = Math.max(ans_max,cur_max);
            
            cur_min = Math.min(cur_min+i,i);
            ans_min = Math.min(ans_min,cur_min);
        }
        
        //all negative
        if(total==ans_min)  return ans_max;
        
        //simple kadane or circular kadane
        return Math.max( ans_max, total-ans_min );
    }
}
