import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int cnt = 0;
    static int r, c, k;
    static boolean[][] visited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (br.read() == 'T') {
                    visited[i][j] = true;
                }
            }
            br.read();
        }
        visited[r - 1][0] = true;

        dfs(r - 1, 0, 1);

        System.out.println(cnt);
    }

    private static void dfs(int x, int y, int depth) {
        if (x == 0 && y == c - 1) {
            if (depth == k) {
                cnt++;
            }
            return;
        }

        for (int[] d : dir) {
            int nx = x + d[0];
            int ny = y + d[1];

            if (nx < 0 || nx >= r || ny < 0 || ny >= c || visited[nx][ny]) {
                continue;
            }

            visited[nx][ny] = true;
            dfs(nx, ny, depth + 1);
            visited[nx][ny] = false;
        }
    }
}
