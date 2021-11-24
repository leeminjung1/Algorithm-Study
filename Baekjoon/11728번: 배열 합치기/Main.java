import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] a = new int[1000001];
    static int[] b = new int[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = n - 1; i >= 0; i--) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = m - 1; i >= 0; i--) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        int x = n - 1, y = m - 1;
        while (x >= 0 && y >= 0) {
            if (a[x] > b[y]) sb.append(b[y--]).append(" ");
            else sb.append(a[x--]).append(" ");
        }
        while (x >= 0) sb.append(a[x--]).append(" ");
        while (y >= 0) sb.append(b[y--]).append(" ");
        System.out.println(sb);
    }
}
