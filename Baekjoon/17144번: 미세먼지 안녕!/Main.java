import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r, c, p;
    static int[][] map;
    static int[][] d = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};   // 시계방향
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        p = 0;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 2; i < r; i++) {
            if (map[i][0] == -1) {
                p = i;
                break;
            }
        }

        while (t-- > 0) {
            diffuse();
            circulate();
        }

        int ans = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans += map[i][j];
            }
        }
        System.out.println(ans + 2);
    }

    private static void diffuse() {
        int[][] tmp = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] > 0) {
                    int amount = map[i][j] / 5;
                    for (int k = 0; k < 4; k++) {
                        int ni = i + d[k][0];
                        int nj = j + d[k][1];
                        if (ni >= 0 && ni < r && nj >= 0 && nj < c && map[ni][nj] != -1) {
                            tmp[ni][nj] += amount;
                            map[i][j] -= amount;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] += tmp[i][j];
            }
        }
    }
    
    private static void circulate() {
        for (int i = 0; i < 2; i++) {
            int x = p + i;
            int y = 0;
            int dir = 2;
            int ceil = i == 0 ? 0 : p + 1;
            int floor = i == 0 ? p + 1 : r;
            while (true) {
                int nx = x + d[dir][0];
                int ny = y + d[dir][1];
                if (nx < ceil || ny < 0 || nx >= floor || ny >= c) {
                    dir += 1 - 2 * i;
                    if (dir == -1) {
                        dir = 3;
                    }
                    dir %= 4;
                    continue;
                }

                if ((nx == p || nx == p + 1) && ny == 0) {
                    break;
                }

                map[x][y] |= map[nx][ny];
                map[nx][ny] = 0;
                x = nx;
                y = ny;
            }
        }
    }
}
