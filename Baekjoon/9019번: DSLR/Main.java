import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int[] parent;
    static char[] chars;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder resultSb = new StringBuilder();
        while (t-- > 0) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            parent = new int[10000];
            chars = new char[10000];
            visited = new boolean[10000];
            visited[a] = true;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(a);
            while (!queue.isEmpty()) {
                int n = queue.poll();
                int D = 2 * n % 10000;
                int S = n == 0 ? 9999 : n - 1;
                int L = n % 1000 * 10 + n / 1000;
                int R = n % 10 * 1000 + n / 10;
                if (!visited[D]) {
                    visited[D] = true;
                    parent[D] = n;
                    chars[D] = 'D';
                    queue.offer(D);
                }
                if (!visited[S]) {
                    visited[S] = true;
                    parent[S] = n;
                    chars[S] = 'S';
                    queue.offer(S);
                }
                if (!visited[R]) {
                    visited[R] = true;
                    parent[R] = n;
                    chars[R] = 'R';
                    queue.offer(R);
                }
                if (!visited[L]) {
                    visited[L] = true;
                    parent[L] = n;
                    chars[L] = 'L';
                    queue.offer(L);
                }

                if (visited[b]) {
                    int c = b;
                    while (c != a) {
                        sb.append(chars[c]);
                        c = parent[c];
                    }
                    sb.reverse();
                    resultSb.append(sb).append('\n');
                    break;
                }
            }

        }
        System.out.print(resultSb);
    }
}
