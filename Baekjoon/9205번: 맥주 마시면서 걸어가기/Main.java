import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Node home = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
          
            Node[] stores = new Node[n];
            boolean[] visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                stores[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            Node penta = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            Arrays.sort(stores, Comparator.comparingInt(o -> distance(o, home)));

            Queue<Node> queue = new LinkedList<>();
            queue.offer(home);

            boolean flag = false;

            while (!queue.isEmpty()) {
                Node now = queue.poll();

                if (distance(now, penta) <= 1000) {
                    flag = true;
                    break;
                }

                for (int i = 0; i < n; i++) {
                    if (!visited[i] && distance(stores[i], now) <= 1000) {
                        visited[i] = true;
                        queue.offer(stores[i]);
                    }
                }
            }

            if (flag) {
                sb.append("happy").append('\n');
            } else {
                sb.append("sad").append('\n');
            }
        }
      
        System.out.println(sb);
    }

    static int distance(Node a, Node b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
