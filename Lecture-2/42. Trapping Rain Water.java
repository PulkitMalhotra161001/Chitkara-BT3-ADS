// https://leetcode.com/problems/trapping-rain-water/

class Solution {
    public int trap(int[] arr) {
        int ans=0, n=arr.length;
        int leftmax=0, rightmax=0;
        int left=0, right=n-1;
        
        while(left<right){
            if(arr[left]<=arr[right]){
                if(arr[left]>=leftmax)  leftmax=arr[left];
                else    ans+=leftmax-arr[left];
                left++;
            }else{
                if(arr[right]>=rightmax)    rightmax=arr[right];
                else    ans+=rightmax-arr[right];
                right--;
            }
        }
        
        return ans;
    }
}
