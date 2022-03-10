import java.io.*;
import java.util.*;

public class Main {

    static int[][] lab, newMap;
    static int n, m;
    static int max = 0;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lab = new int[n][m];
        newMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if(lab[i][j] == 2) list.add(new int[]{i, j});
            }
        }

        solve(0, 0);

        System.out.println(max);
    }

    static void solve(int start, int depth) {
        if (depth == 3) {
            copyMap();
            for (int[] ints : list) {
                dfs(ints);
            }
            max = Math.max(getCount(), max);
            return;
        }

        for (int i = start; i < n * m; i++) {
            int x = i / m;
            int y = i % m;
            if (lab[x][y] == 0) {
                lab[x][y] = 1;
                solve(i + 1, depth + 1);
                lab[x][y] = 0;
            }
        }
    }

    private static void copyMap() {
        for (int i = 0; i < n; i++) {
            System.arraycopy(lab[i], 0, newMap[i], 0, m);
        }
    }

    static void dfs(int[] now) {
        for (int i = 0; i < 4; i++) {
            int x = now[0] + dir[i][0];
            int y = now[1] + dir[i][1];

            if (x >= 0 && x < n && y >= 0 && y < m) {
                if (newMap[x][y] == 0) {
                    newMap[x][y] = 2;
                    dfs(new int[]{x, y});
                }
            }
        }
    }

    private static int getCount() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (newMap[i][j] == 0) count++;
            }
        }
        return count;
    }

}
