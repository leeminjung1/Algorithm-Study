import java.io.*;
import java.util.*;

public class Main {
    static int[] d, dp;
    static ArrayList<Integer>[] edges;
    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            d = new int[n + 1];
            dp = new int[n + 1];
            edges = new ArrayList[n + 1];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i < n + 1; i++) {
                d[i] = Integer.parseInt(st.nextToken());
                edges[i] = new ArrayList<>();
                dp[i] = -1;
            }
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                edges[v].add(u);
            }

            sb.append(dfs(Integer.parseInt(br.readLine()))).append("\n");
        }
        System.out.print(sb);
    }

    private static int dfs(int x) {
        if (dp[x] != -1) {
            return dp[x];
        }
        int max = 0;
        for (int w : edges[x]) {
            max = Math.max(max, dfs(w));
        }
        return dp[x] = max + d[x];
    }
}
