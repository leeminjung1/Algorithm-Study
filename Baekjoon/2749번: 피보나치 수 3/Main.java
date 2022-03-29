import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static final long mod = 1000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        long[][] ans = { { 1, 0 }, { 0, 1 } };
        long[][] data = { { 1, 1 }, { 1, 0 } };

        while (N >= 1) {
            if (N % 2 != 0) {
                ans = getNext(ans, data);
            }
            data = getNext(data, data);
            N /= 2;
        }

        System.out.println(ans[0][1]);
    }

    static long[][] getNext(long[][] a, long[][] b) {
        long[][] ret = new long[2][2];
        ret[0][0] = (a[0][0] * b[0][0] % mod + a[0][1] * b[1][0] % mod) % mod;
        ret[0][1] = (a[0][0] * b[0][1] % mod + a[0][1] * b[1][1] % mod) % mod;
        ret[1][0] = (a[1][0] * b[0][0] % mod + a[1][1] * b[0][1] % mod) % mod;
        ret[1][1] = (a[1][0] * b[0][1] % mod + a[1][1] * b[1][1] % mod) % mod;

        return ret;
    }

}
