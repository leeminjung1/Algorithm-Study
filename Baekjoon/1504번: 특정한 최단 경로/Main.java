import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static int n;
    static final int INF = 200000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][n + 1];
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr[from][to] = weight;
            arr[to][from] = weight;
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int res1 = 0;
        res1 += dijkstra(1, v1);
        res1 += dijkstra(v1, v2);
        res1 += dijkstra(v2, n);

        int res2 = 0;
        res2 += dijkstra(1, v2);
        res2 += dijkstra(v2, v1);
        res2 += dijkstra(v1, n);

        int ans = Math.min(res1, res2);

        if (ans >= INF) {
            ans = -1;
        }

        System.out.println(ans);
    }
    public static int dijkstra(int from, int to) {
        int[] dp = new int[n + 1];
        boolean[] visit = new boolean[n + 1];
        Arrays.fill(dp, INF);
        dp[from] = 0;

        for (int i = 1; i < n + 1; i++) {
            int min = INF;
            int idx = 0;
            for (int j = 1; j < n + 1; j++) {
                if (!visit[j] && dp[j] < min) {
                    min = dp[j];
                    idx = j;
                }
            }

            visit[idx] = true;

            for (int j = 1; j < n + 1; j++) {
                if (!visit[j] && arr[idx][j] != 0 && dp[j] > dp[idx] + arr[idx][j]) {
                    dp[j] = dp[idx] + arr[idx][j];
                }
            }
            if (visit[to]) break;
        }
        return dp[to];
    }
}
