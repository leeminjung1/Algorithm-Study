import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Edge{
        int end, cost;

        public Edge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
    static int n, x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        ArrayList<Edge>[] come = new ArrayList[n + 1];
        ArrayList<Edge>[] back = new ArrayList[n + 1];
        int a, b, t;
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            if (come[a] == null) {
                come[a] = new ArrayList<>();
            }
            if (back[b] == null) {
                back[b] = new ArrayList<>();
            }
            come[a].add(new Edge(b, t));
            back[b].add(new Edge(a, t));
        }

        int[] d1 = getCost(come);
        int[] d2 = getCost(back);

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (max < d1[i] + d2[i]) {
                max = d1[i] + d2[i];
            }
        }
        System.out.println(max);
    }

    private static int[] getCost(ArrayList<Edge>[] arr) {
        int[] d = new int[n + 1];
        Arrays.fill(d, 1000000);
        d[x] = 0;

        ArrayDeque<Edge> queue = new ArrayDeque<>();
        queue.offer(new Edge(x, 0));
        while (!queue.isEmpty()) {
            Edge ed1 = queue.poll();
            for (Edge ed2 : arr[ed1.end]) {
                int cost = d[ed1.end] + ed2.cost;
                if (d[ed2.end] > cost) {
                    d[ed2.end] = cost;
                    queue.add(new Edge(ed2.end, cost));
                }
            }
        }

        return d;
    }
}
