import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static long[] dp = new long[55];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long a = Long.parseLong(input[0]);
        long b = Long.parseLong(input[1]);
        dp[0] = 1;
        for (int i = 1; i < 55; i++) {
            dp[i] = 2 * dp[i - 1] + (1L << i);
        }
        System.out.println(sol(b) - sol(a - 1));
    }

    public static long sol(Long a) {
        long sum = a & 1;
        
        long p;
        for (int i = 54; i > 0; i--) {
            p = 1L << i;
            if ((a & p) > 0) {
                a -= p;
                sum += dp[i - 1] + a + 1;
            }
        }

        return sum;
    }
}
