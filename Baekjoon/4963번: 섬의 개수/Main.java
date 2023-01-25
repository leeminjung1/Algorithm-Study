import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int w, h;
    static char[][] map = new char[50][50];
    static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, 1}, {1, 1}, {-1, -1}, {1, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int cnt;
        while (!(s = br.readLine()).equals("0 0")) {
            st = new StringTokenizer(s);
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            for (int i = 0; i < h; i++) {
                String str = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = str.charAt(j * 2);
                }
            }

            cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == '1') {
                        map[i][j] = '0';
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }

    public static void dfs(int r, int c) {
        for (int[] d : dir) {
            int dx = r + d[0];
            int dy = c + d[1];

            if (dx >= 0 && dy >= 0 && dx < h && dy < w && map[dx][dy] == '1') {
                map[dx][dy] = '0';
                dfs(dx, dy);
            }
        }
    }
}
