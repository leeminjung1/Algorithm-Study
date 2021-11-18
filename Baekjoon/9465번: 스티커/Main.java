import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[2][n+1];
            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= n; k++) {
                    dp[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            for (int j = 2; j <= n; j++) {
                dp[0][j] += Math.max(dp[1][j - 1], dp[1][j - 2]);
                dp[1][j] += Math.max(dp[0][j - 1], dp[0][j - 2]);
            }
            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }
}
