import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static int start = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        dfs(n, m, 0, start);
        System.out.print(sb);
    }

    static void dfs(int n, int m, int depth, int start) {
        if (depth == m) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start; i<n; i++) {
            arr[depth] = i+1;
            dfs(n, m, depth+1, i);
        }
    }
}
