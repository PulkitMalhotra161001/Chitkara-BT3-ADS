class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length, m=nums2.length;
        if(n>m) return findMedianSortedArrays(nums2,nums1);
        
        int k = (n+m+1)/2;
        
        int l=Math.max(0,k-m), r=Math.min(k,n);
        int min=Integer.MIN_VALUE, max=Integer.MAX_VALUE;
        
        //T.C. = O(log(n+m))
        //S.C. = O(1)
        
        while(l<=r){
            
            int cut1 = l+(r-l)/2;
            int cut2 = k - cut1;
            
            int l1 = (cut1==0?min: nums1[cut1-1]);
            int r1 = (cut1>=n?max: nums1[cut1]);
            
            int l2 = (cut2==0?min: nums2[cut2-1]);
            int r2 = (cut2>=m?max: nums2[cut2]);
            
            if(l1<=r2 && l2<=r1){
                
                if( (n+m)%2==0){
                    return (Math.max(l1,l2) + Math.min(r1,r2) ) / 2.0;
                }else{
                    return Math.max(l1,l2);
                }
                
            }else if(l1>r2){
                r=cut1-1;
            }else{
                l=cut1+1;
            }
            
        }
        
        return l;
        
    }
}

//Two pointer approach

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int l = m+n;
        int ans[] = new int[l];
        int i=0, j=0, x=0;
        while(i<m && j<n){
            if(nums1[i] < nums2[j]){
                ans[x++] = nums1[i++];
            }
            else{
                ans[x++] = nums2[j++]; 
            }
        }
        while(i<m){
            ans[x++] = nums1[i++];
        }
        while(j<n){
            ans[x++] = nums2[j++];
        }
        if(l%2==0){
            return (ans[l/2-1] + ans[l/2])/2.0;
        }
        else{
            return (ans[l/2]);
        }
    }
}
