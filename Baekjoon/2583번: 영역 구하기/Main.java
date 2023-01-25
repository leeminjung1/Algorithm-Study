import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] square;
    static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        square = new int[m][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j = x1; j < x2; j++) {
                for (int l = m - y2; l < m - y1; l++) {
                    square[l][j] = 1;
                }
            }
        }

        List<Integer> arr = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (square[i][j] == 0) {
                    square[i][j] = 1;
                    arr.add(dfs(i, j));
                    cnt++;
                }
            }
        }

        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n");
        for (Integer integer : arr) {
            sb.append(integer).append(" ");
        }
        System.out.println(sb);
    }

    public static int dfs(int r, int c) {
        int size = 1;
        for (int i = 0; i < 4; i++) {
            int dx = r + dir[i][0];
            int dy = c + dir[i][1];

            if (dx >= 0 && dy >= 0 && dx < m && dy < n && square[dx][dy] == 0) {
                square[dx][dy] = 1;
                size += dfs(dx, dy);
            }
        }
        return size;
    }
}
