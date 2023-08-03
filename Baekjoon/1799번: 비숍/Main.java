import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int N;
    static boolean[] d;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        d = new boolean[2 * N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j * 2) - '0';
            }
        }

        System.out.println(dfs(0) + dfs(1));
    }

    private static int dfs(int n) {

        if (n >= 2 * N - 1) {
            return 0;
        }

        int max = -1;
        int x = n < N ? 0 : n - (N - 1);
        int y = n < N ? n : N - 1;

        while (y >= 0 && x < N) {
            if (map[y][x] == 1 && !d[x - y + N]) {
                d[x - y + N] = true;
                max = Math.max(max, dfs(n + 2) + 1);
                d[x - y + N] = false;
            }
            x++;
            y--;
        }

        if (max < 0) {
            max = dfs(n + 2);
        }

        return max;
    }
}
