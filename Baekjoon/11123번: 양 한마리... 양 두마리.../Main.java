import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int h, w, cnt;
    static char[][] grid;
    static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            grid = new char[h][w];
            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    grid[i][j] = s.charAt(j);
                }
            }

            cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (grid[i][j] == '#') {
                        grid[i][j] = '.';
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }

    private static void dfs(int x, int y) {
        for (int[] d : dir) {
            int nx = x + d[0];
            int ny = y + d[1];

            if (nx >= 0 && ny >= 0 && nx < h && ny < w && grid[nx][ny] == '#') {
                grid[nx][ny] = '.';
                dfs(nx, ny);
            }

        }
    }
}
