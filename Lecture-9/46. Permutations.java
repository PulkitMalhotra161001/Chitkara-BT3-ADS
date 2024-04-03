class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        int n=nums.length;
        createAllPermutations(0,n,nums);
        return ans;
    }
    void createAllPermutations(int si,int n,int a[]){
        if(si==n){
            //convert a array to list
            List<Integer> temp = new ArrayList<>();
            for(int x:a)    temp.add(x);
            //then add every list(permutation) into our answer
            ans.add(temp);
            return;
        }
        
        //swap with every element to create every permutation
        //starting with current value
        for(int j=si;j<n;j++){
            // System.out.println(si+" "+j+" => "+a[si]+" "+a[j]);
            swap(si,j,a);
            createAllPermutations(si+1,n,a);
            swap(si,j,a);
        }
        // System.out.println();
    }
    
    //swap value's with the given indecies
    void swap(int i,int j,int a[]){
        int temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
