import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] arr, ans, visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        ans = new int[m];
        visited = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        func(0, 0);

        System.out.print(sb);
    }

    private static void func(int depth, int start) {
        if (depth == m) {
            print();
            return;
        }

        for (int i = start, t = -1; i < n; i++) {
            if (visited[i] == 0 && arr[i] != t) {
                visited[i] = 1;
                ans[depth] = arr[i];

                func(depth + 1, i + 1);

                visited[i] = 0;
                t = arr[i];
            }
        }
    }

    private static void print() {
        for (int i = 0; i < m; i++) {
            sb.append(ans[i]).append(" ");
        }
        sb.append("\n");
    }

}
