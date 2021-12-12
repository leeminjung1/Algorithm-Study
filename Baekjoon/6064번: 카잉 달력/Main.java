import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(m < n ? calc(n, m, y, m == x ? 0 : x) : calc(m, n, x, n == y ? 0 : y));
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static int calc (int paramM, int paramN, int paramX, int paramY) {
        int tmp1 = paramM, tmp2 = paramN, max = 1;
        while (max > 0) {
            max = tmp1 % tmp2;
            tmp1 = tmp2;
            tmp2 = max;
        }
        max = paramN / tmp1;
        for (tmp2 = 0; tmp2 < max; tmp2++) {
            tmp1 = tmp2 * paramM + paramX;
            if (tmp1 % paramN == paramY) break;
        }
        return tmp2 == max ? -1 : tmp1;
    }
}
