import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] maze = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }
        
        visited[0][0] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int k = 0; k < 4; k++) {
                int dx = now[0] + dir[k][0];
                int dy = now[1] + dir[k][1];
                if (dx >= 0 && dx < n && dy >= 0 && dy < m && maze[dx][dy] != 0 && !visited[dx][dy]) {
                    queue.add(new int[]{dx, dy});
                    maze[dx][dy] = maze[now[0]][now[1]] + 1;
                    visited[dx][dy] = true;
                }
            }
        }

        System.out.println(maze[n-1][m-1]);
    }

}
