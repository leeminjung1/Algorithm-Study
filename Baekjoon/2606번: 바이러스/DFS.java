import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFS {
    public static int n;
    public static int cnt = 0;
    public static boolean[] visited;
    public static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        map = new int[n + 1][n + 1];
        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }
        dfs(1);
        System.out.println(cnt);
    }

    private static void dfs(int i) {
        visited[i] = true;
        for (int j = 1; j <= n; j++) {
            if (map[i][j] == 1 && !visited[j]) {
                cnt++;
                dfs(j);
            }
        }
    }
}
