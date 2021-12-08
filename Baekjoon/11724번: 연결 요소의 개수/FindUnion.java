import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindUnion {
    static int n;
    static boolean[] visited;
    static int[] node;
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        node = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            node[i] = i;
        }

        visited = new boolean[n + 1];
        int m = Integer.parseInt(st.nextToken());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int root = find(i);
            if (!visited[root]) {
                visited[root] = true;
                answer++;
            }
        }
        System.out.println(answer);

    }

    public static int find(int a) {
        if (node[a] == a)
            return a;
        return node[a] = find(node[a]);
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB) return;
        node[rootB] = rootA;
    }
}
