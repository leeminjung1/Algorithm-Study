import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] t = new int[n];
		int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[n + 1];
		for (int i = n - 1; i >= 0; i--) {
			if (i + t[i] <= n) {
				dp[i] = Math.max(dp[i + 1], p[i] + dp[i + t[i]]);
			} else {
				dp[i] = dp[i + 1];
			}
		}

		System.out.println(dp[0]);
	}
}
