public class Solution {
    public long gridGame(int[][] grid) {
        // Check if the grid has only one column
        if (grid[0].length == 1)
            return 0;

        int n = grid[0].length;

        // Arrays to store prefix and suffix sums of points collected by both robots
        long[] prefixSum = new long[n];
        long[] suffixSum = new long[n];

        // Calculate the suffix sum for the first row
        suffixSum[n - 1] = grid[0][n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + grid[0][i];
        }

        // Calculate the prefix sum for the second row
        prefixSum[0] = grid[1][0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + grid[1][i];
        }

        // Determine the optimal transition index for the second robot
        int transitionIndex = 0;
        for (int i = 0; i < n - 1; i++) {
            if (suffixSum[i + 1] < prefixSum[i]) {
                transitionIndex = i;
                break;
            }
            if (i == n - 2) {
                transitionIndex = n - 1;
                break;
            }
        }

        // Return the maximum points collected by the second robot
        if (transitionIndex == n - 1)
            return prefixSum[transitionIndex - 1];
        if (transitionIndex == 0)
            return suffixSum[transitionIndex + 1];

        return Math.max(suffixSum[transitionIndex + 1], prefixSum[transitionIndex - 1]);
    }
}
/* DRY RUN 

1. **Initialization**:
   - `n = 3` (number of columns)
   - `prefixSum = [0, 0, 0]` (initialized array for prefix sums of the second row)
   - `suffixSum = [0, 0, 0]` (initialized array for suffix sums of the first row)

2. **Calculate Suffix Sum**:
   - `suffixSum[2] = 4` (from `grid[0][2]`)
   - `suffixSum[1] = 4 + 5 = 9` (from `grid[0][1]`)
   - `suffixSum[0] = 9 + 2 = 11` (from `grid[0][0]`)

   `suffixSum` array: `[11, 9, 4]`

3. **Calculate Prefix Sum**:
   - `prefixSum[0] = 1` (from `grid[1][0]`)
   - `prefixSum[1] = 1 + 5 = 6` (from `grid[1][1]`)
   - `prefixSum[2] = 6 + 1 = 7` (from `grid[1][2]`)

   `prefixSum` array: `[1, 6, 7]`

4. **Determine Transition Index**:
   - For `i = 0`:
     - `suffixSum[i + 1] = 9` is not less than `prefixSum[i] = 1`
   - For `i = 1`:
     - `suffixSum[i + 1] = 4` is less than `prefixSum[i] = 6`
     - Set `transitionIndex = 1` and break from the loop.

5. **Return Maximum Points Collected by Second Robot**:
   - Transition index is `1`.
   - Check `suffixSum[transitionIndex + 1] = 4` and `prefixSum[transitionIndex - 1] = 1`.
   - Return `Math.max(4, 1) = 4`.

So, the function returns `4`, which is the correct output for this grid.*/
