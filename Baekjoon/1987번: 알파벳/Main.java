import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int R, C, answer;
    static char[][] map;
    static int[][] visit;
    static int[] dr = new int[]{1, -1, 0, 0};
    static int[] dc = new int[]{0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R + 2][C + 2];

        for (int i = 0; i < R; i++) {
            char[] temp = br.readLine().toCharArray();
            if (C >= 0) System.arraycopy(temp, 0, map[i + 1], 1, C);
        }

        char wall = map[1][1];
        Arrays.fill(map[0], wall);
        Arrays.fill(map[R + 1], wall);
        for (int i = 0; i < R + 2; i++) {
            map[i][0] = wall;
            map[i][C + 1] = wall;
        }

        visit = new int[R + 1][C + 1];
        dfs(1, 1, 1, 1 << map[1][1] - 'A');

        System.out.println(answer);
    }

    private static void dfs(int cnt, int r, int c, int bit){
        answer = Math.max(answer, cnt);
        if (answer == 26)
            return;

        visit[r][c] = bit;

        for (int i = 0; i < 4; i++) {
            int nR = r + dr[i];
            int nC = c + dc[i];
            if ((bit & 1 << (map[nR][nC] - 'A')) == 0
                    && (bit | 1 << (map[nR][nC] - 'A')) != visit[nR][nC]) {
                dfs(cnt + 1, r + dr[i], c + dc[i], bit | 1 << (map[nR][nC] - 'A'));
            }
        }
    }
}
