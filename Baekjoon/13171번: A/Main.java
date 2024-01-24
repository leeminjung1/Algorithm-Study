import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static final int MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long a = Long.parseLong(br.readLine());
        long x = Long.parseLong(br.readLine());
        a %= MOD;
        System.out.println(sol(a, x));
    }

    private static long sol(long a, long x) {
        if (x == 1) {
            return a;
        }

        long result = sol(a, x / 2);
        result *= result;
        result %= MOD;
        if(x % 2 != 0) {
            result *= a % MOD;
        }

        return result % MOD;
    }
}
