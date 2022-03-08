import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

    static class Node implements Comparable<Node> {

        int to, weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }

    }

    public static void main(String[] args) throws Exception {

        int V = read(32) + 1, E = read(13), K = read(13);

        ArrayList<ArrayList<Node>> graph = new ArrayList<>(V);
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            int f = read(32), t = read(32), w = read(13);
            graph.get(f).add(new Node(t, w));
        }

        int[] distance = new int[V];
        dijkstra(graph, V, E, K, distance, new boolean[V]);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < V; i++)
            if (distance[i] == Integer.MAX_VALUE) sb.append("INF").append('\n');
            else sb.append(distance[i]).append('\n');

        System.out.print(sb);

    }

    private static void dijkstra(ArrayList<ArrayList<Node>> G, int V, int E, int K, int[] D, boolean[] visited) {

        for (int i = 0; i < V; i++) D[i] = Integer.MAX_VALUE;
        D[K] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(K, 0));

        while (!pq.isEmpty()) {

            int current = pq.poll().to;

            if (visited[current]) continue;
            visited[current] = true;

            ArrayList<Node> currentNode = G.get(current);
            int size = currentNode.size();

            for (int i = 0; i < size; i++) {
                int t = currentNode.get(i).to;
                int w = currentNode.get(i).weight;

                if (D[t] > D[current] + w) {
                    D[t] = D[current] + w;
                    pq.offer(new Node(t, D[t]));
                }
            }

        }

    }

    private static int read(int flag) throws Exception {

        int c, N = System.in.read() - 48;
        while ((c = System.in.read()) > flag) N = 10 * N + c - 48;

        return N;

    }

}
