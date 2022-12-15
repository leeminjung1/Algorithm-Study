class Solution {
    public static int solution(int alp, int cop, int[][] problems) {
        int x = 0;
        int y = 0;
        for (int[] problem : problems) {
            x = Math.max(problem[0], x);
            y = Math.max(problem[1], y);
        }
        if (x <= alp && y <= cop) {
            return 0;
        }
        alp = Math.min(alp, x);
        cop = Math.min(cop, y);

        int[][] dp = new int[x + 2][y + 2];
        for (int i = alp; i <= x; i++) {
            for (int j = cop; j <= y; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[alp][cop] = 0;

        for (int i = alp; i <= x; i++) {
            for (int j = cop; j <= y; j++) {
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                dp[i][j+ 1] = Math.min(dp[i][j+ 1], dp[i][j] + 1);

                for (int[] p : problems) {
                    if (i >= p[0] && j >= p[1]) {
                        if (i + p[2] > x && j + p[3] > y) {
                            dp[x][y] = Math.min(dp[x][y], dp[i][j] + p[4]);
                        } else if (i + p[2] > x) {
                            dp[x][j + p[3]] = Math.min(dp[x][j + p[3]], dp[i][j] + p[4]);
                        } else if (j + p[3] > y) {
                            dp[i + p[2]][y] = Math.min(dp[i + p[2]][y], dp[i][j] + p[4]);
                        } else if (i + p[2] <= x && j + p[3] <= y) {
                            dp[i + p[2]][j + p[3]] = Math.min(dp[i + p[2]][j + p[3]], dp[i][j] + p[4]);
                        }
                    }
                }
            }
        }

        return dp[x][y];
    }

}
