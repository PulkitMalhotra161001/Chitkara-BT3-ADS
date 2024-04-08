class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        int n=nums1.length, m=nums2.length;
        for(int i=0;i<m;i++)    map.put(nums2[i],i);
        int nge[]=new int[m];
        Stack<Integer> st=new Stack<>();
        for(int i=m-1;i>=0;i--){
            while(!st.isEmpty() && nums2[i]>nums2[st.peek()])   st.pop();
            if(st.isEmpty())    nge[i]=-1;
            else    nge[i]=nums2[st.peek()];
            st.push(i);
            
            // System.out.print(nge[i]+" ");
        }
        
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            ans[i] = nge[ map.get(nums1[i]) ];
        }
        return ans;
    }
}
