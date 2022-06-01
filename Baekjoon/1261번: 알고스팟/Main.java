import java.io.*;
import java.util.*;

public class Main {
    public static class Point {
        int x, y, cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int n, m;
    static Character[][] maze;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        maze = new Character[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = s.charAt(j);
            }
        }

        bfs();
        System.out.println(ans);
    }

    private static void bfs() {
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;

        Deque<Point> dq = new ArrayDeque<>();
        dq.offer(new Point(0, 0, 0));

        while (!dq.isEmpty()) {
            Point p = dq.pollFirst();
            if (p.x == n - 1 && p.y == m - 1) {
                ans = p.cnt;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;

                if (maze[nx][ny] == '0') {
                    dq.offerFirst(new Point(nx, ny, p.cnt));
                } else {
                    dq.offer(new Point(nx, ny, p.cnt + 1));
                }
            }
        }
    }
}
