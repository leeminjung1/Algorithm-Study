import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n + 2][n + 2];
        boolean[] valid = new boolean[101];
        int max = 0;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                valid[map[i][j]] = true;
                max = Math.max(max, map[i][j]);
            }
        }
        int answer = 0;
        for (int high = 1; high <= max; high++) {
            if (!valid[high]) continue;
            int safeArea = 0;
            boolean[][] visited = new boolean[n + 2][n + 2];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (map[i][j] >= high && !visited[i][j]) {
                        checkMap(map, i, j, high, visited);
                        safeArea++;
                    }
                }
            }
            answer = Math.max(answer, safeArea);
        }
        System.out.println(answer);
    }

    static void checkMap(int[][] map, int i, int j, int high, boolean[][] visited) {
        if (map[i][j] < high || visited[i][j]) return;
        visited[i][j] = true;
        checkMap(map, i - 1, j, high, visited);
        checkMap(map, i + 1, j, high, visited);
        checkMap(map, i, j - 1, high, visited);
        checkMap(map, i, j + 1, high, visited);
    }
}
