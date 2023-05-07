import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int v;
        Node link;

        Node(int v, Node link) {
            this.v = v;
            this.link = link;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Node[] graph = new Node[n + 1];
        int[] preCnt = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a] = new Node(b, graph[a]);
            preCnt[b]++;
        }

        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i < n + 1; i++) {
            if (preCnt[i] == 0) {
                queue.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append(" ");

            Node next = graph[cur];
            while (next != null) {
                if (--preCnt[next.v] == 0) {
                    queue.offer(next.v);
                }
                next = next.link;
            }
        }

        System.out.println(sb);
    }
}
