class Solution {
    public int maximumLength(String s) {
        int ans = -1;
        int[] max = new int[26], count = new int[26];
        //last - last seen character. It counts the number of character last
        //len - length of continuous characters of last
        for (int i = 0, n = s.length(), last = -1, len = 0; i <= n; ++i) {
            int c = i < n ? s.charAt(i) - 'a' : -1;

            if (last == c) {
                //count length of continuous characters last
                ++len;
                continue;
            }

            //update maximum length of continuous character.
            //check if occurrence is not less than 3
            if (last != -1 && len >= ans - 1) {
                //max length of charcater last
                if (len > max[last]) {
                    ans = Math.max(ans, max[last] == len - 1 ? len - 1 : len - 2);
                    max[last] = len;
                    count[last] = 1;
                } else if (len == max[last]) {
                    ++count[last];
                    //given that if count is two, then count[last] should be 3 when (len - 1);
                    ans = Math.max(ans, count[last] >= 3 ? len : len - 1);
                } else if (count[last] == 1 && len == max[last] - 1) {
                    //
                    ans = Math.max(ans, len);
                }
            }

            last = c;
            len = 1;
        }

        return ans > 0 ? ans : -1;
    }
}
