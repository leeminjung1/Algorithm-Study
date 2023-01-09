import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {

        ArrayList<ArrayList<Integer>> edge = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            edge.add(new ArrayList<>());
        }

        for (int[] e : edge_list) {
            edge.get(e[0]).add(e[1]);
            edge.get(e[1]).add(e[0]);
        }

        // dp[i][j] : i 초에 j 위치에 있을 수 있는 최소 오류 수정 횟수
        int[][] dp = new int[k][n + 1];
        for (int[] d : dp) {
            Arrays.fill(d, k + 1);
        }

        dp[0][gps_log[0]] = 0;

        for (int i = 1; i < k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                for (Integer e : edge.get(j)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][e]);
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
