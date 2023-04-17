import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] m = new int[N];
        int[] c = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int sumCost = 0;
        for (int i = 0; i < N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
            sumCost += c[i];
        }
        
        int[] dp = new int[sumCost + 1];
        for (int i = 0; i < N; i++) {
            for (int j = sumCost; j >= c[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - c[i]] + m[i]);
            }
            dp[c[i]] = Math.max(dp[c[i]], m[i]);
        }

        for (int i = 0; i < dp.length; i++) {
            if (dp[i] >= M) {
                System.out.println(i);
                return;
            }
        }
    }
}
