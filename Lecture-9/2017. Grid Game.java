class Solution {
    public long gridGame(int[][] grid) {
        int n=grid[0].length;
        //robot1 take some value from lane1 and other values from lans2
        //starting from 1st value from lane1 and switch to lane 2
        long lane1 = 0, lane2 = 0;
        long lane1_ttl = 0, lane2_ttl=0;
        long ans=Long.MAX_VALUE;
        for(int i=0;i<n;i++){
            lane2+=grid[1][i];
            lane1_ttl+=grid[0][i];
            lane2_ttl+=grid[1][i];
        }
        
        for(int i=0;i<n;i++){
            //move to second row at this index
            lane1+=grid[0][i];
            
            //robot2 take the remaining values from lane 1
            long robot_2_lane_1 = lane1_ttl-lane1;
            //robot2 take the remaining values from lane 2
            long robot_2_lane_2 = lane2_ttl-lane2;
            
            long robot1 = lane1+lane2;
            // System.out.println(robot1+" => "+robot_2_lane_1+" "+robot_2_lane_2);
            //robot2 wants to maximize it's value
            //robot1 want to leave the minimum lane value for robot2
            ans = Math.min(ans, Math.max(robot_2_lane_1,robot_2_lane_2));
            
            lane2-=grid[1][i];
        }
        
        return ans;
    }
}
