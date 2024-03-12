class Solution {
   public void permuteRec(int[] nums, int begin, List<List<Integer>> result) {
        // Base case: if begin reaches the length of nums array, add the current permutation to result
        if (begin == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            result.add(temp);
            return;
        }
        
        // Loop through elements starting from index begin
        for (int i = begin; i < nums.length; i++) {
            // Swap current element with the element at index begin
            swap(nums, begin, i);
            // Recursively generate permutations starting from begin + 1
            permuteRec(nums, begin + 1, result);
            // Swap back to maintain the original order for the next iteration
            swap(nums, begin, i);
        }
    }
    
    // Helper method to swap elements in the array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteRec(nums, 0, result);
        return result;
    }
}
