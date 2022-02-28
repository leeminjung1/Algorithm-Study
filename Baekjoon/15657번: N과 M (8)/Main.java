import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] arr, ans;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        ans = new int[m];
        
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        func(0, 0);

        System.out.println(sb);
    }
    
    private static void func(int start, int depth) {
        if (depth == m) {
            print();
            return;
        }

        for (int i = start; i < n; i++) {
            ans[depth] = arr[i];
            func(i, depth + 1);
        }
    }

    private static void print() {
        for (int i = 0; i < m; i++) {
            sb.append(ans[i]).append(" ");
        }
        sb.append("\n");
    }

}
