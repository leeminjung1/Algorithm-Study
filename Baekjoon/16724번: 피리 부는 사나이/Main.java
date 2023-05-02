import java.util.*;
import java.io.*;

public class Main {
    static int cnt = 0;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = br.read();
            }
            br.read();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j);
            }
        }

        System.out.println(cnt);

    }

    static void dfs(int r, int c) {
        if (map[r][c] == 0) {
            cnt++;
            return;
        } else if (map[r][c] == 1) {
            return;
        }

        char d = (char) map[r][c];
        map[r][c] = 0;

        if (d == 'U') {
            dfs(r - 1, c);
        } else if (d == 'D') {
            dfs(r + 1, c);
        } else if (d == 'L') {
            dfs(r, c - 1);
        } else {
            dfs(r, c + 1);
        }

        map[r][c] = 1;
    }
}
