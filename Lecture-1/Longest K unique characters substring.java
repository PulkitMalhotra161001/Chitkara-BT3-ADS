// https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int ans=-1, i=0, j=0, n=s.length();
        Set<Character> set = new HashSet<>();
        int dp[] = new int[26];
        while(j<n){
            dp[s.charAt(j)-'a']++;
            set.add(s.charAt(j));
            j++;
            
            if(set.size()==k){
                ans = Math.max(j-i,ans);
            }
            
            while(set.size()>k){
                dp[s.charAt(i)-'a']--;
                if(dp[s.charAt(i)-'a']==0){
                    set.remove(s.charAt(i));
                }
                i++;
            }
            //T.C. = O(n)
            //S.C. = O(n)
        }
        return ans;
    }
}
