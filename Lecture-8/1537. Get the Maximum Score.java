class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        long a=0, b=0;
        int n=nums1.length, m=nums2.length, mod=(int)1e9+7;
        int i=0, j=0;
        
        while(i<n && j<m){
            if(nums1[i]<nums2[j])   a+=nums1[i++];
            else if(nums1[i]>nums2[j])  b+=nums2[j++];
            else{
                b=a=Math.max(a,b)+nums1[i++];
                j++;
            }
        }
        
        while(i<n)  a+=nums1[i++];
        while(j<m)  b+=nums2[j++];
        
        return (int)(Math.max(a,b)%mod);
    }
}
