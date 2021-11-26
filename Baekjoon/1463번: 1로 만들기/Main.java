import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Throwable {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 1000001;
        int[] dp = new int[max];
        for (int i = 2; i <= n; i++) {
            int a = i % 2 == 0 ? dp[i / 2] : max;
            int b = i % 3 == 0 ? dp[i / 3] : max;
            int c = dp[i - 1];
            dp[i] = Math.min(a, Math.min(b, c)) + 1;
        }
        System.out.println(dp[n]);
    }
}
