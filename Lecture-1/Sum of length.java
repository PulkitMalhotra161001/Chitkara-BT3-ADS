// https://www.geeksforgeeks.org/problems/sum-of-length3345/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

class Solution {
    long sumoflength(long arr[], int n) {
        int i=0, j=0;
        long ans=0;
        Set<Long> set = new HashSet<>();
        
        while(j<n){
            while(set.contains(arr[j])){
                set.remove(arr[i]);
                i++;
            }
            
            set.add(arr[j]);
            j++;
            
            long len = j-i;
            ans+=(len*(len+1))/2;
        }
        return ans;
    }
}
