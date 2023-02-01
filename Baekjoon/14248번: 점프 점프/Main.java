import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] A;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        A = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int s = Integer.parseInt(br.readLine());
        visit = new boolean[n + 1];

        dfs(s);

        int cnt = 0;
        for (boolean v : visit) {
            if (v) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void dfs(int s) {
        
        visit[s] = true;
        
        for (int i = -1; i <= 1; i += 2) {
            int next = s + i * A[s];
            if (next >= 1 && next <= n && !visit[next]) {
                dfs(next);
            }
        }
    }
}
