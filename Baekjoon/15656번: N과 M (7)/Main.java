import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] arr;
    static int[] ans = new int[7];

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sort();

        func(0);
        System.out.print(sb);

    }

    private static void sort() {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }

    private static void func(int depth) {
        if (depth == m) {
            print();
            return;
        }

        for (int i = 0; i < n; i++) {
            ans[depth] = arr[i];
            func(depth + 1);
        }
    }

    private static void print() {
        for (int i = 0; i < m; i++) {
            sb.append(ans[i]).append(" ");
        }
        sb.append("\n");
    }

}
