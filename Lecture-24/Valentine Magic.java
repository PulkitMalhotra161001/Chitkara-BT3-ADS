// https://codeskiller.codingblocks.com/problems/281

import java.util.Arrays;
import java.util.Scanner;

class Main {
    static long valentine(long [][]dp,long[] choc, long[] candy, int i, int j) {
        if (i == choc.length) {
            return 0;
        }
        if (j == candy.length) {
            return (long)Integer.MAX_VALUE;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        long diff = Math.abs(choc[i] - candy[j]);
        long q1 = valentine(dp, choc, candy, i + 1, j + 1) + diff;
        long q2 = valentine(dp, choc, candy, i, j + 1);

        dp[i][j] = Math.min(q1, q2);

        return dp[i][j];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //No of boys
        int m = sc.nextInt(); //No of girls

        long[] choc = new long[n];
        long[] candy = new long[m];
        for (int i = 0; i < n; i++) {
            choc[i] = sc.nextLong();
        }
        for (int i = 0; i < m; i++) {
            candy[i] = sc.nextLong();
        }

        long [][]dp = new long[n+1][m+1];

        for (long[] longs : dp) {
            Arrays.fill(longs, -1);
        }

        Arrays.sort(choc);
        Arrays.sort(candy);

        System.out.println(valentine(dp, choc, candy, 0, 0));
    }
}
