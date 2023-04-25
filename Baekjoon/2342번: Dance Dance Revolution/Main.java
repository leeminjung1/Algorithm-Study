import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] a = new int[5];
        for (int i = 1; i < 5; i++) {
            a[i] = 4000000;
        }
        int cur = 0;
        while (st.hasMoreTokens()) {
            int move = Integer.parseInt(st.nextToken());
            if (move == 0) {
                break;
            }
            int min = 4000000;
            int w = score(cur, move);
            for (int i = 0; i < 5; i++) {
                min = Math.min(min, a[i] + score(i, move));
                a[i] += w;
            }
            a[cur] = min;
            cur = move;
        }

        int ans = a[0];
        for (int i = 1; i < 5; i++) {
            ans = Math.min(ans, a[i]);
        }
        System.out.println(ans);
    }

    private static int score(int cur, int move) {
        if (cur == move) {
            return 1;
        }
        if (cur == 0) {
            return 2;
        }
        if (cur - move == 2 || cur - move == -2) {
            return 4;
        }
        return 3;
    }
}
