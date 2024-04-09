class Solution {
    public int largestRectangleArea(int[] arr) {
        int n=arr.length;
        Stack<Integer>st=new Stack<>();
        Stack<Integer>s=new Stack<>();
        int le[]=new int[n];
        int re[]=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                le[i]=0;
            }
            else{
                le[i]=st.peek()+1;
            }
            st.push(i);
        }
        for(int i=n-1;i>=0;i--){
            while(!s.empty()&&arr[s.peek()]>=arr[i]){
                s.pop();
          }
          if(s.isEmpty()){
              re[i]=n;
          }
          else{
              re[i]=s.peek();
          }
          s.push(i);
        }
        int res[]=new int[n];
        for(int i=0;i<n;i++){
            res[i]=Math.abs(re[i]-le[i])*arr[i];
        }
        Arrays.sort(res);
        return res[n-1];
    }
}
