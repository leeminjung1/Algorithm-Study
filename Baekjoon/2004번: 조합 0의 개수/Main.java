import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        long n5 = powerOfN(5, n) -  powerOfN(5, n-m) - powerOfN(5, m);
        long n2 = powerOfN(2, n) -  powerOfN(2, n-m) - powerOfN(2, m);
        System.out.println(Math.min(n5, n2));
    }

    private static long powerOfN(long n, long x) {
        long cnt = 0;
        while (x >= n) {
            cnt += x/n;
            x /= n;
        }
        return cnt;
    }
}
