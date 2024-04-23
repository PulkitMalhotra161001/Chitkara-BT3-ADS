class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        int n = nums.length;
        
        for(int i=0;i<(1<<n);i++){
            //i represent which element we have to choose
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<n;j++){
                // if((i&(1<<j)) >0){
                if ((i >> j & 1) == 1) {
                    list.add(nums[j]);
                }
            }
            ans.add(list);
        }
        
        return ans;
    }
}
