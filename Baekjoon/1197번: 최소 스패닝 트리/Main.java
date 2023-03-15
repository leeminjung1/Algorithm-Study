import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class V implements Comparable<V>{
        int u, v, w;

        public V(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(V o) {
            return this.w - o.w;
        }
    }

    public static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        V[] graph = new V[e];
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i] = new V(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(graph);

        parent = new int[v + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        int ans = 0;
        for (V vertex : graph) {
            if (findParent(vertex.u) != findParent(vertex.v)) {
                union(vertex.u, vertex.v);
                ans += vertex.w;
            }
        }

        System.out.println(ans);
    }

    private static void union(int u, int v) {
        u = findParent(u);
        v = findParent(v);
        if (u != v) {
            parent[v] = u;
        }
    }

    private static int findParent(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = findParent(parent[x]);
        }
    }
}
