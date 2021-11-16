import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] box = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(box[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for(int k=0; k<4; k++) {
                int dx = now[0] + dir[k][0];
                int dy = now[1] + dir[k][1];
                if (dx >= 0 && dx < n && dy >= 0 && dy < m && box[dx][dy] == 0) {
                    queue.add(new int[]{dx, dy});
                    box[dx][dy] = box[now[0]][now[1]] + 1;
                }
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, box[i][j]);
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(max - 1);

    }
}
