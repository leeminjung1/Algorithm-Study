import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> nodes;
    static int[] parent;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        nodes = new ArrayList<>();
        parent = new int[n - 1];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            nodes.get(a).add(b);
            nodes.get(b).add(a);
        }

        bfs();

        StringBuilder sb = new StringBuilder();
        for (int x : parent) {
            sb.append(x).append("\n");
        }
        System.out.println(sb);

    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int node : nodes.get(x)) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                    parent[node - 1] = x + 1;
                }
            }
        }
    }

}
