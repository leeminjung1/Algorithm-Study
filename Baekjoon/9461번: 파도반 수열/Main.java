import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long[] p = new long[101];
        p[1] = p[2] = p[3] = 1;
        p[4] = 2;
        for (int i = 5; i <= 100; i++) {
            p[i] = p[i - 1] + p[i - 5];
        }
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            sb.append(p[Integer.parseInt(br.readLine())]).append('\n');
        }
        System.out.println(sb);
    }
}
