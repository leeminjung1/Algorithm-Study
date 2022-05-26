import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[] m = new int[500002];
        for (int i = 0; i < n/2; i++) {
            m[Integer.parseInt(br.readLine())]--;
            m[h - Integer.parseInt(br.readLine())]++;
        }

        int x = n/2;
        int ans = n;
        int cnt = 0;
        for (int i = 0; i < h; i++) {
            x += m[i];
            if (x < ans) {
                ans = x;
                cnt = 1;
            } else if (x == ans) {
                cnt ++;
            }
        }

        System.out.println(ans + " " + cnt);
    }
}
