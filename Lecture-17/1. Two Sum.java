class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer>  map = new HashMap<>();

        int n=nums.length;
        for(int i=0;i<n;i++){
            if(map.containsKey(target-nums[i])){
                int value_id = map.get(target-nums[i]);
                
                int ans[] = new int[2];
                ans[0]=value_id;
                ans[1]=i;
                return ans;
                
            }
            map.put(nums[i],i);
        }
        
        return new int[]{-1,-1};
    }
}
