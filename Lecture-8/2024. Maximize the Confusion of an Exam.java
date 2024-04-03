class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(solve(answerKey,k,'T'), solve(answerKey,k,'F'));
    }
    int solve(String s,int k,char c){
        //c char we don't want
        int ans=0, n=s.length();
        int i=0, j=0, count=0;
        while(j<n){
            //if we encounter one
            if(s.charAt(j)==c){
                count++;
                
                while(count>k){
                    if(s.charAt(i)==c){
                        count--;
                    }
                    i++;
                }
                    
            }
            
            j++;
            ans=Math.max(j-i,ans);
        }
        return ans;
    }
}
