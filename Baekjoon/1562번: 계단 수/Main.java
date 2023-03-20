import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][][] dp = new int[n][10][4];
        for (int i = 1; i <= 8; i++) {
            dp[0][i][0] = 1;
        }
        dp[0][9][2] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j][3] = (dp[i][j][3] + dp[i - 1][j + 1][2] + dp[i - 1][j + 1][3]) % MOD;
                    dp[i][j][1] = (dp[i][j][1] + dp[i - 1][j + 1][0] + dp[i - 1][j + 1][1]) % MOD;
                } else if (j == 9) {
                    dp[i][j][3] = (dp[i][j][3] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][3]) % MOD;
                    dp[i][j][2] = (dp[i][j][2] + dp[i - 1][j - 1][0] + dp[i - 1][j - 1][2]) % MOD;
                } else {
                    for (int k = 0; k <= 3; k++) {
                        dp[i][j][k] = (dp[i - 1][j - 1][k] + dp[i - 1][j + 1][k]) % MOD;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans = (ans + dp[n - 1][i][3]) % MOD;
        }
        System.out.println(ans);
    }
}
