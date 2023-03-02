import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] w = new int[1000000];
        int[] r = new int[1000000];
        for (int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(br.readLine());
        }
        r[n - 1] = w[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            r[i] = Math.max(r[i + 1], w[i]);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, w[i]);
            sb.append(max).append(' ').append(r[i]).append('\n');
        }
        System.out.print(sb);
    }
}
