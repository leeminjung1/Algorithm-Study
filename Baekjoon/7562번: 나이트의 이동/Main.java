import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int x;
        int y;
        int cnt = 0;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    private static final int[][] d = new int[][]{{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int l = Integer.parseInt(br.readLine());
            Node[] nodes = new Node[2];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                nodes[i] = new Node(x, y);
            }
            int ans = bfs(nodes, l);
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }

    private static int bfs(Node[] nodes, int n) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(nodes[0]);

        boolean[][] visited = new boolean[n][n];
        visited[nodes[0].x][nodes[0].y] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.x == nodes[1].x && node.y == nodes[1].y) {
                return node.cnt;
            }

            for (int i = 0; i < 8; i++) {
                int dx = node.x + d[i][0];
                int dy = node.y + d[i][1];

                if (dx < 0 || dy < 0 || dx >= n || dy >= n) {
                    continue;
                }

                if (!visited[dx][dy]) {
                    visited[dx][dy] = true;
                    queue.offer(new Node(dx, dy, node.cnt + 1));
                }
            }
        }
        return -1;
    }
}
