import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int cnt;
    static int[][] arr = new int[5][5];
    static int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[] visited = new boolean[10_000_000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 1, arr[i][j]);
            }
        }

        System.out.println(cnt);
    }

    private static void dfs(int i, int j, int depth, int val) {
        if (depth == 6) {
            if (!visited[val]) {
                visited[val] = true;
                cnt++;
            }
            return;
        }

        for (int[] d : dir) {
            int ni = i + d[0];
            int nj = j + d[1];

            if (ni >= 0 && nj >= 0 && ni < 5 && nj < 5) {
                dfs(ni, nj, depth + 1, val * 10 + arr[ni][nj]);
            }
        }

    }
}
