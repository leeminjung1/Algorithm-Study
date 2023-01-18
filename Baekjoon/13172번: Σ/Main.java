import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MOD = 1_000_000_007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        long sum = 0;
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int gcd = gcd(n, s);
            n /= gcd;
            s /= gcd;
            sum += s * pow(n) % MOD;
            sum %= MOD;
        }

        System.out.print(sum);
    }

    static long pow(long n) {
        long r = 1;
        int p = MOD - 2;
        while (p > 0) {
            if ((p & 1) == 1) r = r * n % MOD;
            n = n * n % MOD;
            p >>= 1;
        }
        return r;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
