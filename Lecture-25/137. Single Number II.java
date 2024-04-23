class Solution {
    /*
    concept of bucket
        -  add to bucket one, if not in two's
        -  add to bucket two, if not in one's (because we just removed from one's bucket)
    */
    public int singleNumber(int[] nums) {
        //add in one's, if not in two's
        //add in two's, if is in one's
        //add in three's, if is in two's
        
        int one=0, two=0;
        for(int i:nums){
            
            one = (one^i)&(~two);
            
            two = (two^i)&(~one);
            
        }
        
        return one;
    }
    
    /*
    public int singleNumber(int[] nums) {
        int ans=0;
        
        for(int b=0;b<32;b++){
            
            int val = (1<<b), set=0;
            
            for(int i:nums){

                //for 31st bit value become -ve so for and operator 
                //while left shifting we have to check for value not_equal_to_zero
                if( ( i&(1<<b) ) != 0) set++;
                
                //right shift will work
                // if( ( (i>>b)&1 ) > 0) set++;
                
                set%=3;
                
            }
            
            //set value will be one only becase everyone else occuring thrice
            if(set>0)   ans|=val;
        }
        
        return ans;
        
    }
    */
}

/*
Try for [2,2,2,1]

one = (2)&(all bits set) => 2
two = (2)&(all 2 bit not_set) => 0

one = (0)&(all bits set) => 0
two = (2)&(all bit set) => 2

one = (2)&(all 2 bit not_set) => 0
two = (0)&(all bits set) => 0
(because number will go on 'three' bucket logically we don't reqiured that)

one = (1)&(all bit set) => 1
two = (1)&(all 1 bit not_set) => 0
*/
