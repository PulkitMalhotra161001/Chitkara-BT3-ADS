class Solution {
    public boolean find132pattern(int[] nums) {
        //left_smallest (1)
        int n=nums.length, ls[] = new int[n];
        
        for(int i=0;i<n;i++){
            if(i==0)    ls[i] = nums[i];
            else    ls[i] = Math.min(ls[i-1],nums[i]);
        }
        
        Stack<Integer> st = new Stack<>();

        //3
        for(int i=n-1;i>=0;i--){
            //1<3
            if(ls[i]<nums[i]){
                //1>=2 remove
                while(!st.isEmpty() && ls[i]>=st.peek())  st.pop();

                //surity 1<2, already 1<3
                
                //3>2
                if(!st.isEmpty() && nums[i]>st.peek())  return true;
            }
            
            //2
            st.push(nums[i]);
        }
        
        return false;
    }
}
