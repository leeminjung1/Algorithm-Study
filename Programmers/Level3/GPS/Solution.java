class Solution {
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {

        int[][] map = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            map[edge_list[i][0]][edge_list[i][1]] = 1;
            map[edge_list[i][1]][edge_list[i][0]] = 1;
        }

        int[][] dp = new int[k][n + 1];
        for(int i = 0; i < k; i++) {
            for(int j = 0; j < n + 1; j++) {
                dp[i][j] = k + 1;
            }
        }
        dp[0][gps_log[0]] = 0;
        
        for (int i = 1; i < k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);

                for (int e = 1; e < n + 1; e++) {
                    if (map[j][e] == 1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][e]);
                    }
                }

                if (gps_log[i] != j) {
                    dp[i][j]++;
                }
            }
        }

        int answer = dp[k - 1][gps_log[k - 1]];
        return answer > k ? -1 : answer;
    }
}
