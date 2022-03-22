import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class Main {
    private static int ans = 0;
    private static Node[] tree;
    private static boolean[] visited;
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        tree = new Node[V + 1];
        visited = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            while (true) {
                int v = Integer.parseInt(st.nextToken());
                if (v == -1) {
                    break;
                }
                int w = Integer.parseInt(st.nextToken());
                tree[u] = new Node(v, w, tree[u]);
            }
        }

        dfs(1);
        System.out.println(ans);
    }

    private static int dfs(int n) {
        visited[n] = true;

        int a = 0, b = 0;
        for (Node next = tree[n]; next != null; next = next.next) {
            if (!visited[next.n]) {
                int tmp = dfs(next.n) + next.d;

                if (tmp > a) {
                    b = a;
                    a = tmp;
                    continue;
                }
                if (tmp > b) {
                    b = tmp;
                }
            }
        }

        int sum = a + b;
        if (ans < sum) {
            ans = sum;
        }
        return a;
    }

    private static class Node {
        int n, d;
        Node next;
      
        public Node(int n, int d, Node node) {
            this.n = n;
            this.d = d;
            next = node;
        }
    }
  
}
