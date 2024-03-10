class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //only one answer exist or no answer exist
        int total=0, till_now=0, n=gas.length, ans=0;
        for(int i=0;i<n;i++){
            total+=gas[i]-cost[i];
            
            till_now+=gas[i]-cost[i];
            if(till_now<0){
                //means till_now indecies is not valid because we are not able to move fwrd
                ans=i+1;
                till_now=0; //reset out tank because we have to find our starting point
                //from that start there must be fuel there to travel to next cities
            }
        }
        //if fuel exists or all fuel used then we can say that there is a valid path
        return total>=0?ans:-1;
    }
}
