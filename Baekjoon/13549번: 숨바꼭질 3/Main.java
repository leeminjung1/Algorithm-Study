import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[K + 1];

        for (int i = 0; i <= K; i++) {
            if (i <= N) {
                dp[i] = N - i;
            } else {
                dp[i] = dp[i - 1] + 1;
                int t = (i & 1) == 0 ? dp[i >> 1] : dp[(i + 1) >> 1] + 1;
                dp[i] = Math.min(dp[i], t);
            }
        }

        System.out.println(dp[K]);
    }
}
