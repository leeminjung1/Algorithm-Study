import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public final static int MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int d = Integer.parseInt(br.readLine());
        long[][] dp = new long[8][2];
        dp[0][0] = 1;
        while (d-- > 0) {
            dp[0][1] = dp[1][0] + dp[7][0];
            dp[1][1] = dp[0][0] + dp[2][0] + dp[7][0];
            dp[2][1] = dp[1][0] + dp[3][0] + dp[6][0] + dp[7][0];
            dp[3][1] = dp[2][0] + dp[4][0] + dp[6][0];
            dp[4][1] = dp[3][0] + dp[5][0];
            dp[5][1] = dp[4][0] + dp[6][0];
            dp[6][1] = dp[2][0] + dp[3][0] + dp[5][0] + dp[7][0];
            dp[7][1] = dp[0][0] + dp[1][0] + dp[2][0] + dp[6][0];

            for (int i = 0; i < 8; i++) {
                dp[i][0] = dp[i][1] % MOD;
            }
        }

        System.out.println(dp[0][0]);
    }
}
