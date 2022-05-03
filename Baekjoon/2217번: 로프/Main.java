import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] rope = new int[10001];
        for (int i = 0; i < n; i++) {
            rope[Integer.parseInt(br.readLine())]++;
        }

        int max = 0;
        for (int i = 10000, j = 0; i > 0; i--) {
            j += rope[i];
            max = Math.max(max, i * j);
        }
        System.out.println(max);
    }
}
