import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static boolean[][] aisle;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        aisle = new boolean[n + 1][m + 1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            aisle[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
        }

        int max = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (aisle[i][j]) {
                    max = Math.max(max, dfs(i, j));
                }
            }
        }

        System.out.println(max);
    }

    private static int dfs(int i, int j) {
        int sum = 1;
        aisle[i][j] = false;
        for (int[] d : dir) {
            int nx = i + d[0];
            int ny = j + d[1];

            if (nx < 1 || nx > n || ny < 1 || ny > m || !aisle[nx][ny]) {
                continue;
            }

            sum += dfs(nx, ny);
        }

        return sum;
    }
}
