import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dp = new int[m + 1];
        int ans = 0;
        int upLeft; int up;
        for (int i = 1; i <= n; i++) {
            upLeft = 0;
            for (int j = 1; j <= m; j++) {
                up = dp[j];
                dp[j] = br.read() == '1' ? Math.min(up, Math.min(dp[j - 1], upLeft)) + 1 : 0;
                upLeft = up;
                ans = Math.max(ans, dp[j]);
            }
            br.read();
        }

        System.out.println(ans * ans);
        
    }
}
