import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int ans = m;

        boolean[] people = new boolean[n + 1];
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= t; i++) {
            people[Integer.parseInt(st.nextToken())] = true;
        }

        parent = new int[n + 1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        ArrayList<Integer>[] party = new ArrayList[m + 1];
        for (int i = 1; i <= m; i++) {
            party[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            if (k > 1) {
                for (int j = 1; j < k; j++) {
                    int b = Integer.parseInt(st.nextToken());
                    if (find(a) != find(b)) {
                        union(a, b);
                    }
                    party[i].add(b);
                }
            }
            party[i].add(a);
        }

        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (people[i] && !visited[i]) {
                int root = find(i);
                for (int j = 1; j <= n; j++) {
                    if (find(j) == root) {
                        people[j] = true;
                        visited[j] = true;
                    }
                }
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int x : party[i]) {
                if (people[x]) {
                    ans--;
                    break;
                }
            }
        }

        System.out.println(ans);
    }

    private static void union(int a, int b) {
        int parentB = find(b);
        parent[parentB] = a;
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
}
