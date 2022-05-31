import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] graph = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) graph[i] = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(to, w));
        }

        st = new StringTokenizer(br.readLine()," ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        boolean[] isVisited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        int[] from = new int[n + 1];
        from[start] = start;
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        while(!isVisited[end]) {
            int minidx = 0, minval = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                if (!isVisited[i] && minval > distance[i]) {
                    minidx = i;
                    minval = distance[i];
                }
            }

            isVisited[minidx] = true;
            if(isVisited[end]) break;

            for(Edge edge : graph[minidx]) {
                int target = edge.to;
                int w = edge.w;

                if (!isVisited[target] && distance[target] > distance[minidx] + w) {
                    distance[target] = distance[minidx] + w;
                    from[target] = minidx;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(distance[end]).append('\n');

        Stack<Integer> path = new Stack<>();
        while(end != start) {
            path.add(end);
            end = from[end];
        }
        path.add(start);

        sb.append(path.size()).append('\n');

        while(!path.isEmpty()) {
            sb.append(path.pop()).append(" ");
        }

        System.out.println(sb);
    }

    static class Edge {
        int to, w;

        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }
}
