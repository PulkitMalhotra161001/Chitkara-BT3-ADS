class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length, n=matrix[0].length, dp[]=new int[n], ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                dp[j]=matrix[i][j]=='0'?0:dp[j]+1;
            ans = Math.max(ans, largestRectangleArea(dp));
        }
        return ans;
    }
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int ls[]=new int[n];
        int rs[]=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i])  st.pop();
            ls[i] = (st.isEmpty()?-1:st.peek());
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i])  st.pop();
            rs[i] = (st.isEmpty()?n:st.peek());
            st.push(i);
        }
        
        // for(int i:ls)   System.out.print(i+" ");
        // System.out.println();
        // for(int i:rs)   System.out.print(i+" ");
        // System.out.println();
        
        int ans=0;
        for(int i=0;i<n;i++){
            // if(ls[i]==-1 || rs[i]==n)   continue;
            int temp = (rs[i]-ls[i]-1)*heights[i];
            // System.out.println("i: "+i+" "+temp);
            ans = Math.max(ans, temp);
        }
        
        return ans;
    }
}
