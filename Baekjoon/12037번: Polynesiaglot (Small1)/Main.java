import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final long mod = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int x = 1; x <= t; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            long[] dpC = new long[l + 1];
            long[] dpV = new long[l + 1];
            dpC[1] = c;
            dpV[1] = v;

            for (int i = 1; i < l; i++) {
                dpC[i + 1] = (dpV[i] * c) % mod;
                dpV[i + 1] = ((dpV[i] + dpC[i]) * v) % mod;
            }

            long y = dpV[l];
            
            sb.append("Case #").append(x).append(": ").append(y).append("\n");
        }
        System.out.print(sb);
    }
}
