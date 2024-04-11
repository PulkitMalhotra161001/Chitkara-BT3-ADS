class Solution {
    public int searchInsert(int[] nums, int t) {
        return bs(nums,0,nums.length-1,t);        
    }
    public int bs(int a[],int i,int j,int t){
        while(i<=j){
            int mid=(i+j)/2;
            if(a[mid]==t){
                return mid;
            }
            else if(t<a[mid]){
                return bs(a,i,mid-1,t);
            }
            else{
                return bs(a,mid+1,j,t);
            }
        }
        return i;
    }
}
