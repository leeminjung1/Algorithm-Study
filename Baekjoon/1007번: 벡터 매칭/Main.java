import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static double min;
    static int[][] points;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            points = new int[n][2];
            min = Double.MAX_VALUE;
            int sumX = 0;
            int sumY = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                sumX += points[i][0] = Integer.parseInt(st.nextToken());
                sumY += points[i][1] = Integer.parseInt(st.nextToken());
            }

            dfs(sumX, sumY, 0, 0);

            sb.append(min).append('\n');
        }

        System.out.print(sb);
    }

    private static void dfs(long sumX, long sumY, int idx, int cnt) {
        if (n - idx + cnt < n / 2) {
            return;
        }

        if (cnt == n / 2) {
            min = Math.min(min, Math.sqrt(sumX * sumX + sumY * sumY));
            return;
        }

        for (int i = idx; i < n; i++) {
            dfs(sumX - 2L * points[i][0], sumY - 2L * points[i][1], i + 1, cnt + 1);
        }

    }
}
