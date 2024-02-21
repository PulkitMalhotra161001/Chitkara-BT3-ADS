// https://leetcode.com/problems/product-of-array-except-self/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans,1);
        
        int left=1, right=1;
        for(int i=1;i<n;i++){
            
            left*=nums[i-1];
            ans[i]*=left;
            
            // System.out.println(i+" "+left);
        }
        
        // for(int i:ans){
        //     System.out.print(i+" ");
        // }
        // System.out.println();
        
        //S.C. = O(n)
        
        for(int i=n-2;i>=0;i--){
            
            right*=nums[i+1];
            ans[i]*=right;
        }
        
        return ans;
    }
}
