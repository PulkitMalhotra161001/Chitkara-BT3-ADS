class Solution {
    
    //there's a staright line and then a pointer pointing to inside of a straight line (making circle/loop)
    //slow and fast pointer meet at a point
    //Dist(slow)*2    =   Dist(fast)
    //A=straight line,  B=point after loop (meeting),    C=remaining loop dist
    //(A+n(B+C) +B)*2     =     A+m(B+C)+B
    //A+B = (n-m)(B+C)  where as n-m = λ
    //λ=1   A+B=B+C     A=C
    //λ=2   A+B=2(B+C)  B+C(loop)   A=2B+2C-B   A=(B+C)+C   A=C
    
    public int findDuplicate(int[] nums) {
        int a=0, b=nums[0];
        while(a!=b){
            a=nums[a];
            b=nums[nums[b]];
        }
        // System.out.println(a);
        b=nums[b];
        a=0;
        while(a!=b){
            a=nums[a];
            b=nums[b];
        }
        return b;
    }
    
    /*
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            int index=Math.abs(nums[i]);
            if(nums[index]<0)   return index;
            nums[index]=-nums[index];
        }
        return -1;
    }
    */
}
