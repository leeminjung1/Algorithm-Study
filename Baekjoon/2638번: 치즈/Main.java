import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;
    private static ArrayDeque<int[]> air = new ArrayDeque<>();
    private static final int[] dx = { 1, -1, 0, 0 };
    private static final int[] dy = { 0, 0, 1, -1 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j * 2) - 48;
            }
        }
        air.add(new int[] { 0, 0 });

        int time = 0;
        while (true) {
            int size = air.size();

            while (size-- > 0) {
                int[] tmp = air.poll();
                dfs(tmp[0], tmp[1]);
            }

            if (air.isEmpty()) {
                break;
            }
            time++;
        }
        System.out.println(time);
    }

    private static void dfs(int x, int y) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ((nx >= 0 && nx < M && ny >= 0 && ny < N) && !visited[ny][nx]) {
                if (map[ny][nx] != 0) {
                    if (++map[ny][nx] == 3) {
                        air.add(new int[]{nx, ny});
                    }
                } else {
                    dfs(nx, ny);
                }
            }
        }
    }
}
