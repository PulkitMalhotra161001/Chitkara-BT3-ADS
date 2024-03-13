class Solution {
    public int tribonacci(int n) {
        int first=0, second=1, third=1;
        if(n==0)    return first;
        if(n==1)    return second;
        if(n==2)    return third;
        
        for(int i=3;i<=n;i++){
            int add = first+second+third;
            
            first=second;
            second=third;
            third=add;
        }
        
        return third;
    }
    
    //TLE
//     public int tribonacci(int n) {
//         if(n==0)    return 0;
//         if(n==1)    return 1;
//         if(n==2)    return 1;
        
//         return tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
//     }
}
