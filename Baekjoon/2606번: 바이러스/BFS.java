import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        
        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int cnt = 0;
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            for (int k = 1; k <= n; k++) {
                if (map[temp][k] == 1 && !visited[k]) {
                    queue.offer(k);
                    visited[k] = true;
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
