import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, cnt;
    static char[][] campus;
    static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        campus = new char[n][m];

        int ix = 0, iy = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = s.charAt(j);
                if (c == 'I') {
                    ix = i;
                    iy = j;
                }
                campus[i][j] = c;
            }
        }

        dfs(ix, iy);

        System.out.println(cnt == 0 ? "TT" : cnt);
    }

    private static void dfs(int x, int y) {
        
        if (campus[x][y] == 'P') {
            cnt++;
        }
        
        campus[x][y] = 'X';
        
        for (int[] d : dir) {
            int nx = x + d[0];
            int ny = y + d[1];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m && campus[nx][ny] != 'X') {
                dfs(nx, ny);
            }
        }
    }
}
