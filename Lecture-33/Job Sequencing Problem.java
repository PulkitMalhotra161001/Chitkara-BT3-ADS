class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr,(o1,o2)->o2.profit-o1.profit);
        // int max_deadline=0;
        // for(Job i:arr)  max_deadline=Math.max(max_deadline,i.deadline);
        boolean dotd[]=new boolean[n+1];
        int ans[]=new int[2];
        for(Job j:arr){
            for(int i=j.deadline;i>=1;i--){
                if(!dotd[i]){
                    dotd[i]=true;
                    ans[1]+=j.profit;
                    ans[0]++;
                    break;
                }
            }
        }
        return ans;
    }
}
