import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFS {
    static int n, m, max;
    static int[][] paper;
    static boolean[][] visited;
    static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        max = 0;
        paper = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, 0, 0);
                exc(i, j);
            }
        }

        System.out.println(max);
    }

    private static void dfs(int r, int c, int depth, int sum) {
        if (depth >= 4) {
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int x = r + move[i][0];
            int y = c + move[i][1];
            if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y]) continue;
            visited[x][y] = true;
            dfs(x, y, depth + 1, sum + paper[x][y]);
            visited[x][y] = false;
        }
    }

    private static void exc(int r, int c) {
        int wings = 4;
        int min = Integer.MAX_VALUE;
        int sum = paper[r][c];
        for (int i = 0; i < 4; i++) {
            int x = r + move[i][0];
            int y = c + move[i][1];
            if (wings <= 2) {
                return;
            }
            if (x < 0 || x >= n || y < 0 || y >= m) {
                wings--;
                continue;
            }
            min = Math.min(min, paper[x][y]);
            sum += paper[x][y];
        }
        if (wings == 4) {
            sum -= min;
        }
        max = Math.max(max, sum);
    }

}
