import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class no1916 {
    private static class Node implements Comparable<Node>{
        public int end;
        public int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;

        ArrayList<ArrayList<Node>> graph = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken()) - 1;
        int B = Integer.parseInt(st.nextToken()) - 1;

        int[] dist = new int[N];
        for (int i = 0; i < N; i++) dist[i] = Integer.MAX_VALUE;
        dist[A] = 0;

        boolean[] visited = new boolean[N];

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(A, 0));

        while (!queue.isEmpty()) {
            int current = queue.poll().end;

            if (visited[current]) continue;
            visited[current] = true;

            ArrayList<Node> currentNode = graph.get(current);

            for (Node node : currentNode) {
                int t = node.end;
                int w = node.weight;
                if (dist[t] > dist[current] + w) {
                    dist[t] = dist[current] + w;
                    queue.add(new Node(t, dist[t]));
                }

            }
        }

        System.out.println(dist[B]);
    }
}
