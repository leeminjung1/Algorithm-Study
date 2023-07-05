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
        String[] map = new String[n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine();
        }

        int[] dp = new int[m + 1];
        int ans = 0;
        int cur; int next;
        for (int i = 1; i <= n; i++) {
            cur = 0;
            for (int j = 1; j <= m; j++) {
                next = dp[j];
                dp[j] = map[i - 1].charAt(j - 1) == '1' ? Math.min(dp[j], Math.min(dp[j - 1], cur)) + 1 : 0;
                cur = next;
                ans = Math.max(ans, dp[j]);
            }
        }

        System.out.println(ans * ans);
        
    }
}
