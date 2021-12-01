import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int o = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = n - 1;
            while (start < end) {
                int mid = start + end >>> 1;
                if (a[mid] >= o) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            sb.append(a[end] == o ? 1 : 0).append('\n');
        }

        System.out.println(sb);
    }
}
