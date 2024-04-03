class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        
        int ri = 0;
        for (int i = 0; i < nums.length; i++) {
            // Remove indices that are out of the current window
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            
            // Remove smaller elements from the back of the deque
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            // Add the current index to the deque
            deque.offer(i);
            
            // If the current window is of size k, add the maximum element to the result array
            if (i >= k - 1) {
                result[ri++] = nums[deque.peek()];
            }
        }
        
        return result;
    }
}
/*      BRUTE FORCE
  int n = nums.length;
  if (n == 0 || k == 0) {
    return new int[0];
  }
  
  int numOfWindow = n - k + 1;
  int[] result = new int[numOfWindow];
  
  for (int start = 0; start < numOfWindow; ++start) {
    int end = start + k - 1;
    int maxVal = nums[start];
    for (int i = start + 1; i <= end; ++i) {
      if (nums[i] > maxVal) {
        maxVal = nums[i];
      }
    }
    result[start] = maxVal;
  }
  
  return result;
}*/
