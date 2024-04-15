class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int ans=0;
        for(int i:nums) set.add(i);
        
        for(int i:nums){
            if(!set.contains(i-1)){
                int x=i, seq=0;
                while(set.contains(x)){
                    x++;
                    seq++;
                }
                ans=Math.max(ans,seq);
                
                //consecutive seq can't be more than half size
                if(seq>nums.length/2)    break;
            }
        }
        
        return ans;
    }
}
