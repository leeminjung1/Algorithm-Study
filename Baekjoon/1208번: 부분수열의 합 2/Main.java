import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int ZERO = 2000000;
    static int n, s;
    static long cnt = 0;
    static int[] arr, cntSubSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        cntSubSum = new int[ZERO * 2 + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, n / 2, 0);
        dfs(n / 2, n, 0);

        System.out.println(s == 0 ? cnt - 1 : cnt);
    }

    private static void dfs(int idx, int end, int sum) {
        if (idx == end) {
            if (end == n / 2) {
                cntSubSum[sum + ZERO]++;
            } else {
                int other = s - sum + ZERO;
                if (0 <= other && other <= ZERO * 2) {
                    cnt += cntSubSum[other];
                }
            }
            return;
        }

        dfs(idx + 1, end, sum + arr[idx]);
        dfs(idx + 1, end, sum);

    }
}
