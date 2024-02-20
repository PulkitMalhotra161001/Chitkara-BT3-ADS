// https://leetcode.com/problems/max-consecutive-ones-iii/

class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0, j=0, ans=0, used=0, n=nums.length;
        while(j<n){
            if(nums[j]==0){
                used++;
            }
            j++;
            
            if(used<=k){
                ans = Math.max(ans, j-i);
            }
            // T.C. = O(n)
            // S.C. = O(1)
            
            while(used>k){
                if(nums[i]==0){
                    used--;
                }
                i++;
            }
        }
        return ans;
    }
}
