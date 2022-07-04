import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int v;
        int d;
        Node next;
        Node(int v, int d, Node next) {
            this.v = v;
            this.d = d;
            this.next = next;
        }
    }

    static class Queue {
        int[] queue;
        int head;
        int tail;
        Queue() {
            queue = new int[16];
            clear();
        }
        void clear() {
            head = tail = -1;
        }
        boolean isEmpty() {
            return head == tail;
        }
        void offer(int e) {
            queue[++head & 15] = e;
        }
        int poll() {
            return queue[++tail & 15];
        }
    }

    static int N, M, R;
    static int[] items, dist;
    static Node[] graph;
    static Queue queue;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()) + 1;
        R = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        items = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        graph = new Node[N + 1];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph[u] = new Node(v, d, graph[u]);
            graph[v] = new Node(u, d, graph[v]);
        }

        int max = 0;
        queue = new Queue();
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dijkstra(i));
        }

        System.out.print(max);
    }

    static int dijkstra(int u) {

        for (int i = 1; i <= N; i++) dist[i] = M;

        queue.clear();
        queue.offer(u);
        dist[u] = 0;

        while (!queue.isEmpty()) {

            u = queue.poll();

            for (Node node = graph[u]; node != null; node = node.next) {
                int v = node.v;
                int d = node.d + dist[u];
                if (dist[v] > d && M > d) {
                    dist[v] = d;
                    queue.offer(v);
                }
            }
        }

        int item = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] < M) {
                item += items[i];
            }
        }

        return item;
    }
}
