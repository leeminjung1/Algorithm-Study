import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] node;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        node = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            node[a][b] = node[b][a] = 1;
        }
        sb = new StringBuilder();
        visit = new boolean[n + 1];
        dfs(v);
        System.out.println(sb);

        sb = new StringBuilder();
        visit = new boolean[n + 1];
        bfs(v);
        System.out.println(sb);
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visit[v] = true;
        sb.append(v).append(' ');
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (node[x][i] == 1 && !visit[i]) {
                    visit[i] = true;
                    queue.offer(i);
                    sb.append(i).append(' ');
                }
            }
        }
    }

    private static void dfs(int iter) {
        visit[iter] = true;
        sb.append(iter).append(' ');
        for (int i = 1; i <= n; i++) {
            if (node[iter][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }
}
