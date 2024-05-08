class Solution
{
    //Function to find the maximum number of activities that can
    //be performed by a single person.
    public static int activitySelection(int start[], int end[], int n)
    {
        int arr[][]=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=start[i];
            arr[i][1]=end[i];
        }
        Arrays.sort(arr,(o1,o2)->o1[1]-o2[1]);
        int last_end=-1, ans=0;
        for(int i=0;i<n;i++){
            if(arr[i][0]>last_end){
                last_end=arr[i][1];
                ans++;
            }
        }
        return ans;
    }
}
