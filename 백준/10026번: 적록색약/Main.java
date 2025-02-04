import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static char[][] grid;
    static boolean[][] visited;
    static int[][] move = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(solve()).append(' ');
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'G') {
                    grid[i][j] = 'R';
                }
            }
        }
        sb.append(solve());
        System.out.println(sb);
    }

    private static int solve() {
        visited = new boolean[n][n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        char current = grid[x][y];
        for (int i = 0; i < 4; i++) {
            int r = x + move[i][0];
            int c = y + move[i][1];
            if (r < 0 || r >= n || c < 0 || c >= n) continue;
            if(!visited[r][c] && grid[r][c] == current) dfs(r,c);
        }
    }

}
