/*To find the maximum length subarray whose all elements are prime in an array using Kadane's algorithm and the Sieve of Eratosthenes, you can follow these steps:

1. Use the Sieve of Eratosthenes to pre-calculate all prime numbers up to a certain limit.
2. Iterate through the input array and mark each element with either `1` if it's prime or `0` if it's not.
3. Apply Kadane's algorithm to find the maximum subarray sum of consecutive prime numbers.

Here's the Java code implementing this approach:

*/
import java.util.Arrays;

class maxLengthPrimeSubarray {
    public int funmaxLengthPrimeSubarray(int[] nums) {
        // Step 1: Sieve of Eratosthenes to pre-calculate primes
        boolean[] primes = sieveOfEratosthenes(1000000);
        
        // Step 2: Mark each element in the array as 1 if prime, 0 if not
        for (int i = 0; i < nums.length; i++) {
            if (primes[nums[i]]) {
                nums[i] = 1;
            } else {
                nums[i] = 0;
            }
        }
        
        // Step 3: Apply Kadane's algorithm
        int maxEndingHere = 0;
        int maxSoFar = 0;
        
        for (int i = 0; i < nums.length; i++) {
            maxEndingHere = Math.max(0, maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
    }

    // Sieve of Eratosthenes to find all primes up to a limit
    private boolean[] sieveOfEratosthenes(int limit) {
        boolean[] primes = new boolean[limit + 1];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;

        for (int i = 2; i * i <= limit; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    primes[j] = false;
                }
            }
        }
        
        return primes;
    }
}

// Time Complexity: O(N * log(log(N))) for the Sieve of Eratosthenes + O(N) for Kadane's algorithm
// Space Complexity: O(N) for the boolean array of primes
/*In this code:

The sieveOfEratosthenes method generates a boolean array where primes[i] is true if i is a prime number, and false otherwise.
In the maxLengthPrimeSubarray method, we first mark each element in the input array as 1 if it's prime and 0 if it's not.
Then, we apply Kadane's algorithm to find the maximum subarray sum of consecutive prime numbers in the modified array.
Finally, we return the maximum subarray sum, which represents the maximum length subarray whose all elements are prime. */
