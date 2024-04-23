class Solution {
    public int[] singleNumber(int[] nums) {
        //bcz we are xor-1 (and int min_value-1 will overflow)
        long xor=0;
        for(int i:nums)     xor^=i;
        
        //for finding the rightMost set bit
        //instead of loop
        //first we remove rightMost set bit and xor it will give the rightMost set bit
        int bit = (int) (( xor&(xor-1) )^(xor));
        
        int a=0, b=0;
        for(int i:nums){
            if( (i&bit) >0 )    a^=i;
            else    b^=i;
        }
        
        return new int[]{a,b};
    }
}
