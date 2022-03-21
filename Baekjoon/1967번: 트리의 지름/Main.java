import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] parent = new int[n + 1][2];
        int[] cost = new int[n + 1];

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            parent[c][0] = p;
            parent[c][1] = w;
        }

        int diameter = 0;
        for (int c = n; c > 0; c--) {
            int p = parent[c][0];
            int w = parent[c][1];
            if (cost[p] + cost[c] + w > diameter) {
                diameter = cost[p] + cost[c] + w;
            }
            if (cost[p] < cost[c] + w) {
                cost[p] = cost[c] + w;
            }
        }
        System.out.println(diameter);
    }
}
